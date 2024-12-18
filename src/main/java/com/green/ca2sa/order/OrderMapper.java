package com.green.ca2sa.order;

import com.green.ca2sa.order.model.OrderPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int insOrder(OrderPostReq p);
}
