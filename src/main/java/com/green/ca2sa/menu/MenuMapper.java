package com.green.ca2sa.menu;

import com.green.ca2sa.menu.model.MenuDelReq;
import com.green.ca2sa.menu.model.MenuGetReq;
import com.green.ca2sa.menu.model.MenuGetRes;
import com.green.ca2sa.menu.model.MenuPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    int insMenu(MenuPostReq p);
    List<MenuGetRes> selMenuList(MenuGetReq p);
    int deleteMenu(MenuDelReq p);
}
