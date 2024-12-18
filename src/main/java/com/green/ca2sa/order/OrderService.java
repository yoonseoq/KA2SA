package com.green.ca2sa.order;

import com.green.ca2sa.order.model.OrderPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;

    public int PostOrder(OrderPostReq p){
        int result = orderMapper.insOrder(p);
        return result;
    }
}
