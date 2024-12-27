package com.green.ca2sa.menu.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MenuGetRes {
   private List<MenuGetDto> menu;
   private long categoryId;
   private String categoryName;
}
