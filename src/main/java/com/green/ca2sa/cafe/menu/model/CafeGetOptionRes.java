package com.green.ca2sa.cafe.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeGetOptionRes {
    private String optionName;
    private long menuOptionId;
    private int addPrice;
    private String menuName;
}
