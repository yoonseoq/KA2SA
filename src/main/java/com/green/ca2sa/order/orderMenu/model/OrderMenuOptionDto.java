package com.green.ca2sa.order.orderMenu.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class OrderMenuOptionDto {
    private Long menuOptionId;
    private String optionName;
    private int addPrice;
    private int required;


}
