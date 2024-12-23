package com.green.ca2sa.cafe.menu.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeGetOptionRes {
    private String optionName;
    private int addPrice;
    private int required;
    private String menuName;
}
