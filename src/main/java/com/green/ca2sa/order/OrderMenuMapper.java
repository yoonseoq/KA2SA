package com.green.ca2sa.order;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMenuMapper {
    int insOrderMenu(int orderId);
}
