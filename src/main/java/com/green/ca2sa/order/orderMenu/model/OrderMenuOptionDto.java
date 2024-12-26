package com.green.ca2sa.order.orderMenu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderMenuOptionDto {
    private Long menuOptionId;
    private String optionName;
    private int addPrice;


}
