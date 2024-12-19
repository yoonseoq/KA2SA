package com.green.ca2sa.order;

import com.green.ca2sa.order.model.OrderGetReq;
import com.green.ca2sa.order.model.OrderGetRes;
import com.green.ca2sa.order.model.OrderPostReq;
import com.green.ca2sa.order.orderMenu.OrderMenuMapper;
import com.green.ca2sa.order.orderMenu.OrderMenuOptionMapper;
import com.green.ca2sa.order.orderMenu.model.OrderMenuOptionPostReq;
import com.green.ca2sa.order.orderMenu.model.OrderMenuPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderMenuMapper orderMenuMapper;
    private final OrderMenuOptionMapper orderMenuOptionMapper;
    @Transactional
    public int PostOrder(OrderPostReq p){
        List<OrderMenuPostReq> menuList = new ArrayList<>(p.getMenuList().size());
        List<OrderMenuOptionPostReq> optionList = new ArrayList<>();
        for (OrderMenuPostReq item : p.getMenuList()) {
            item.setOrderId(p.getOrderId());
            menuList.add(item);
            for (OrderMenuOptionPostReq option : item.getOptions()) {
                option.setOrderMenuId(item.getOrderMenuId());
                optionList.add(option);
            }
        }
        int result = orderMapper.insOrder(p);
        int result2 = orderMenuMapper.insOrderMenu(menuList);
        int result3 = orderMenuOptionMapper.insOrderMenuOption(optionList);
        return result;






    }

    public List<OrderGetRes> GetOrderList(OrderGetReq p){
        List<OrderGetRes> orderList = orderMapper.getOrderList(p);
        return orderList;
    }
}
