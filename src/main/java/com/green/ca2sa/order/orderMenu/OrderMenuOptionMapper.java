package com.green.ca2sa.order.orderMenu;

import com.green.ca2sa.order.orderMenu.model.OrderMenuOptionPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMenuOptionMapper {
    int insOrderMenuOption(OrderMenuOptionPostReq p);
}
