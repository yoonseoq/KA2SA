package com.green.ca2sa.order.orderMenu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderMenuDto {

    private long orderMenuId;
    private String menuName;
    private int price;

    private List<OrderMenuOptionDto> orderMenuOptions;
}
