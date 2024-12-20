package com.green.ca2sa.order.orderMenu.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class OrderMenuOptionGetDto {
    private long orderMenuId;
    private long menuOptionId;
    private String optionName;
    private int addPrice;
    private int required;


}
