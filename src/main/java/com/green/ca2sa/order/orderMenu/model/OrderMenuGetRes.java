package com.green.ca2sa.order.orderMenu.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderMenuGetRes {
    private long orderId;
    private long menuId;
    private String menuName;
    private int price;
    private int count;


}
