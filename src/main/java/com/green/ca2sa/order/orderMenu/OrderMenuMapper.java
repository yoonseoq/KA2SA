package com.green.ca2sa.order.orderMenu;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMenuMapper {
    int insOrderMenu(int orderId);
}
