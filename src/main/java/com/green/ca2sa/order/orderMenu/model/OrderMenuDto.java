package com.green.ca2sa.order.orderMenu.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class OrderMenuDto {

    private long orderMenuId;
    private String menuName;
    private int price;
    private int count;

    private List<OrderMenuOptionDto> orderMenuOptions;
}
