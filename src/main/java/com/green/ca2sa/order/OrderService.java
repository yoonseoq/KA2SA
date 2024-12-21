package com.green.ca2sa.order;

import com.green.ca2sa.order.model.OrderGetReq;
import com.green.ca2sa.order.model.OrderGetRes;
import com.green.ca2sa.order.model.OrderPostReq;
import com.green.ca2sa.order.orderMenu.OrderMenuMapper;
import com.green.ca2sa.order.orderMenu.OrderMenuOptionMapper;
import com.green.ca2sa.order.orderMenu.model.OrderMenuDto;
import com.green.ca2sa.order.orderMenu.model.OrderMenuOptionDto;
import com.green.ca2sa.order.orderMenu.model.OrderMenuOptionPostReq;
import com.green.ca2sa.order.orderMenu.model.OrderMenuPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderMenuMapper orderMenuMapper;
    private final OrderMenuOptionMapper orderMenuOptionMapper;

    @Transactional
    public int PostOrder(OrderPostReq p) {
        log.info("OrderPostReq:{}", p);
        int result = orderMapper.insOrder(p);
        // xml에 foreach문 사용해서 올리기
        List<OrderMenuPostReq> menuList = p.getMenuList().stream()
                .peek(item -> item.setOrderId(p.getOrderId())) //오더 아이디 다 집어 넣어주는거 그냥 for문 돌리면서 값 넣어주는거로 보면 된다
                .toList();
        List<OrderMenuOptionPostReq> optionList = new ArrayList<>();

        int result2 = orderMenuMapper.insOrderMenu(menuList);
        //db에 넣는용도로 만든 변수. 단순 데이터 저장

        long orderMenuId = menuList.get(0).getOrderMenuId();
        for (OrderMenuPostReq item : p.getMenuList()) {
            for (OrderMenuOptionPostReq option : item.getOptions()) { // 옵션
                option.setOrderMenuId(orderMenuId); // 오더 메뉴아이디 받거 세팅하고
                optionList.add(option); // 옵션을 추가한다
            }
            orderMenuId++;   //그리고 메뉴 추가
        }
        int result3 = orderMenuOptionMapper.insOrderMenuOption(optionList);
        //db에 넣는용도로 만든 변수. 단순 데이터 저장
        return result;
    }

    public List<OrderGetRes> GetOrderList(OrderGetReq p) {
        log.info("OrderGetReq:{}", p);
        List<OrderGetRes> orderList = orderMapper.getOrderList(p); // 일단 주문목록 조회
        Map<Long, OrderGetRes> orderMap = new LinkedHashMap<>();
        for (OrderGetRes order : orderList) {
            OrderGetRes orderDto = orderMap.computeIfAbsent(order.getOrderId(), key -> {
                OrderGetRes newOrder = new OrderGetRes();
                newOrder.setOrderId(order.getOrderId());
                newOrder.setNickName(order.getNickName());
                newOrder.setCafeName(order.getCafeName());
                newOrder.setLocation(order.getLocation());
                newOrder.setPickUpTime(order.getPickUpTime());
                newOrder.setOrderMenuList(new ArrayList<>()); // 초기화
                return newOrder;
            });

            if (order.getOrderMenuList() != null && order.getOrderMenuList().size() > 0) {
                for (OrderMenuDto orderMenu : order.getOrderMenuList()) {
                    OrderMenuDto menuDto = orderDto.getOrderMenuList().stream()
                            .filter(m -> m.getOrderMenuId() == orderMenu.getOrderMenuId())
                            .findFirst().orElseGet(() -> {
                                OrderMenuDto newMenu = new OrderMenuDto();
                                newMenu.setOrderMenuId(orderMenu.getOrderMenuId());
                                newMenu.setMenuName(orderMenu.getMenuName());
                                newMenu.setPrice(orderMenu.getPrice());
                                newMenu.setOrderMenuOptions(new ArrayList<>());
                                orderDto.getOrderMenuList().add(newMenu);
                                return newMenu;
                            });

                    if (menuDto.getOrderMenuOptions() != null) {
                        for (OrderMenuOptionDto optionDto : menuDto.getOrderMenuOptions()) {
                            if (menuDto.getOrderMenuOptions().stream()
                                    .noneMatch(o -> o.getMenuOptionId()
                                            == optionDto.getMenuOptionId())) {
                                menuDto.getOrderMenuOptions().add(optionDto);
                            }
                        }
                    }


                }
            }
        }
        return new ArrayList<>(orderMap.values());
    }



/*
    public List<OrderGetRes> GetOrderList2(OrderGetReq p) {
        // 1. 주문 리스트 조회
        List<OrderGetRes> orderList = orderMapper.getOrderList(p);

        for (OrderGetRes order : orderList) {
            long orderId = order.getOrderId();

            // 2. 주문별 메뉴 리스트 조회
            List<OrderMenuDto> orderMenuList = orderMapper.getOrderMenu(orderId);

            for (OrderMenuDto orderMenu : orderMenuList) {
                long orderMenuId = orderMenu.getOrderMenuId();

                // 3. 메뉴별 옵션 리스트 조회
                List<OrderMenuOptionGetDto> menuOptionList = orderMapper.selOrderMenuOption(orderMenuId);

                // 4. 옵션 리스트를 메뉴에 설정
                orderMenu.setOptionList(menuOptionList);
            }

            // 5. 메뉴 리스트를 주문에 설정
            order.setMenuList(orderMenuList);
        }

        // 6. 로그 출력
        log.info("Order List with Menus and Options: {}", orderList);

        // 7. 최종 데이터 반환
        return orderList;
    }


 */
}
