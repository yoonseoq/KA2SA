package com.green.ca2sa.order;

import com.green.ca2sa.order.model.OrderGetReq;
import com.green.ca2sa.order.model.OrderGetRes;
import com.green.ca2sa.order.model.OrderPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int insOrder(OrderPostReq p);
    List<OrderGetRes> getOrderList(OrderGetReq p);
}
