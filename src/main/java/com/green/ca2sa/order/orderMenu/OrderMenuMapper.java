package com.green.ca2sa.order.orderMenu;

import com.green.ca2sa.order.orderMenu.model.OrderMenuGetReq;
import com.green.ca2sa.order.orderMenu.model.OrderMenuGetRes;
import com.green.ca2sa.order.orderMenu.model.OrderMenuPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMenuMapper {
    int insOrderMenu(List<OrderMenuPostReq> p);
    List<OrderMenuGetRes> getOrderMenu(OrderMenuGetReq p);
}
