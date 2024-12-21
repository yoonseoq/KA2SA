package com.green.ca2sa.order.orderMenu.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class OrderMenuOptionDto {
    private long orderMenuId;
    private Long menuOptionId;
    private String optionName;
    private int addPrice;
    private int required;


}
