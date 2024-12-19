package com.green.ca2sa.order;

import com.green.ca2sa.order.model.OrderGetReq;
import com.green.ca2sa.order.model.OrderGetRes;
import com.green.ca2sa.order.model.OrderPostReq;
import com.green.ca2sa.order.orderMenu.OrderMenuMapper;
import com.green.ca2sa.order.orderMenu.model.OrderMenuPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderMenuMapper orderMenuMapper;
    @Transactional
    public int PostOrder(OrderPostReq p){
        OrderMenuPostReq orderMenuPostReq = new OrderMenuPostReq();

        int result = orderMapper.insOrder(p);
        return result;






    }

    public List<OrderGetRes> GetOrderList(OrderGetReq p){
        List<OrderGetRes> orderList = orderMapper.getOrderList(p);
        return orderList;
    }
}
