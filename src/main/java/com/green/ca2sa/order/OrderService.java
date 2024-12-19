package com.green.ca2sa.order;

import com.green.ca2sa.order.model.OrderGetReq;
import com.green.ca2sa.order.model.OrderGetRes;
import com.green.ca2sa.order.model.OrderPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderMenuMapper orderMenuMapper;

    public int PostOrder(OrderPostReq p){
        int result = orderMapper.insOrder(p);
        return result;






    }

    public List<OrderGetRes> GetOrderList(OrderGetReq p){
        List<OrderGetRes> orderList = orderMapper.getOrderList(p);
        return orderList;
    }
}
