package com.green.ca2sa.cafe.menu.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeGetMenuRes {
    private long menuId;
    private String menuName;
    private int price;
    private String menuPic;
    private String comment;
}
