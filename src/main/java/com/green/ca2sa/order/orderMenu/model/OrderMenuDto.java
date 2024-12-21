package com.green.ca2sa.order.orderMenu.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderMenuDto {
    private long orderId;
    private long menuId;
    private long orderMenuId;
    private String menuName;
    private int price;

    private List<OrderMenuOptionDto> orderMenuOptions;
}
