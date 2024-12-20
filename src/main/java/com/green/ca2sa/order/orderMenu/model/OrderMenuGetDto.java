package com.green.ca2sa.order.orderMenu.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderMenuGetDto {
    private long orderId;
    private long menuId;
    private long orderMenuId;
    private String menuName;
    private int price;
}
