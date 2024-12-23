package com.green.ca2sa.cafe.order;

import com.green.ca2sa.cafe.order.model.CafeOrderPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeOrderService {
    private final CafeOrderMapper cafeOrderMapper;

    public int updCafeOrder(CafeOrderPutReq p){
        return cafeOrderMapper.updCafeOrder(p);
    }
}
