package com.green.ca2sa.menu.option.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuOptionPutReq {
    private long menuId;
    private long menuOptionId;
    private String optionName;
    private int addPrice;
    private int required;
}