package com.green.ca2sa.order.orderMenu;

import com.green.ca2sa.order.orderMenu.model.OrderMenuOptionPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMenuOptionMapper {
    int insOrderMenuOption(List<OrderMenuOptionPostReq> p);
}
