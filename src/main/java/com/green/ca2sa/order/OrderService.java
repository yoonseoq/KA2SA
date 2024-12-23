package com.green.ca2sa.order;

import com.green.ca2sa.order.model.OrderCancelReq;
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
        long startTime = System.currentTimeMillis();
        log.info("OrderPostReq:{}", p);
        int result = orderMapper.insOrder(p);
        // xml에 foreach문 사용해서 올리기
        List<OrderMenuPostReq> menuList = p.getMenuList().stream()
                .peek(item -> item.setOrderId(p.getOrderId())) //오더 아이디 다 집어 넣어주는거 그냥 for문 돌리면서 값 넣어주는거로 보면 된다
                .toList();
        List<OrderMenuOptionPostReq> optionList = new LinkedList<>();

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
        log.info("post order cost time:{}", System.currentTimeMillis() - startTime);
        return result;
    }

    public List<OrderGetRes> GetOrderList(OrderGetReq p) {
        long startTime = System.currentTimeMillis();
        log.info("OrderGetReq:{}", p);
        List<OrderGetRes> orderList = orderMapper.getOrderList(p); // 일단 주문목록 조회
        log.info("order list from mapper : {}", orderList);

        Map<Long, OrderGetRes> orderMap = new HashMap<>();
        for (OrderGetRes order : orderList) {
            OrderGetRes orderDto = orderMap.computeIfAbsent(order.getOrderId(), key ->
                    OrderGetRes.builder()
                        .orderId(order.getOrderId())
                        .nickName(order.getNickName())
                        .cafeName(order.getCafeName())
                        .location(order.getLocation())
                        .pickUpTime(order.getPickUpTime())
                        .memo(order.getMemo())
                        .createdAt(order.getCreatedAt())
                        .orderMenuList(new LinkedList<>())
                        .build()
            );

            if (order.getOrderMenuList() != null) {
                for (OrderMenuDto orderMenu : order.getOrderMenuList()) {
                    OrderMenuDto menuDto = orderDto.getOrderMenuList().stream()
                            .filter(m -> m.getOrderMenuId() == orderMenu.getOrderMenuId())
                            .findFirst().orElseGet(() ->
                                OrderMenuDto.builder()
                                        .orderMenuId(orderMenu.getOrderMenuId())
                                        .menuName(orderMenu.getMenuName())
                                        .price(orderMenu.getPrice())
                                        .orderMenuOptions(new LinkedList<>())
                                        .build()
                            );

                    if (orderMenu.getOrderMenuOptions() != null) {
                        for (OrderMenuOptionDto optionDto : orderMenu.getOrderMenuOptions()) {
                            // 중복된 옵션이 없을 경우에만 추가
                            boolean exists = menuDto.getOrderMenuOptions().stream()
                                    .anyMatch(o -> Objects.equals(o.getMenuOptionId(), optionDto.getMenuOptionId()));
                            if (!exists) {
                                menuDto.getOrderMenuOptions().add(
                                        OrderMenuOptionDto.builder()
                                                .menuOptionId(optionDto.getMenuOptionId())
                                                .optionName(optionDto.getOptionName())
                                                .addPrice(optionDto.getAddPrice())
                                                .required(optionDto.getRequired())
                                                .build()
                                );
                            }
                        }
                    }
                }
            }
        }
        log.info("get order list process cost time:{}", System.currentTimeMillis() - startTime);
        return new ArrayList<>(orderMap.values());
    }

    public int cancelOrder(OrderCancelReq p){
        int result = orderMapper.cancelOrder(p);
        return result;
    }
}




