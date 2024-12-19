package com.green.ca2sa.order.orderMenu;

import com.green.ca2sa.order.orderMenu.model.OrderMenuPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMenuMapper {
    int insOrderMenu(OrderMenuPostReq p);
}
