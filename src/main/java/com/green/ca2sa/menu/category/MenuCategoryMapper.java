package com.green.ca2sa.menu.category;

import com.green.ca2sa.menu.category.model.MenuCategoryGetReq;
import com.green.ca2sa.menu.category.model.MenuCategoryGetRes;
import com.green.ca2sa.menu.category.model.MenuCategoryPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuCategoryMapper {
    int insCategory(MenuCategoryPostReq p);
    List<MenuCategoryGetRes> getMenuCategory(MenuCategoryGetReq p);
}
