package com.green.ca2sa.menu;

import com.green.ca2sa.menu.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    int insMenu(MenuPostReq p);
    List<MenuGetRes> selMenuList(MenuGetReq p);
    int deleteMenu(MenuDelReq p);

    // 내가 한것
    List<MenuDetailGetRes> getMenuDetailInfo(MenuDetailGetReq p);

    // 내가 한것
    List<MenuGetRes> getMenuInfo(MenuGetReq p);

    //내가 한 것
    int updateMenuInfo(MenuPutReq p);
}
