package com.green.ca2sa.cafe.order;

import com.green.ca2sa.cafe.order.model.CafeOrderPutReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeOrderMapper {
    int updCafeOrder(CafeOrderPutReq p);
}
