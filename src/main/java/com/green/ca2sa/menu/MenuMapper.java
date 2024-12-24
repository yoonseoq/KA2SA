package com.green.ca2sa.menu;

import com.green.ca2sa.menu.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    int postMenuInfo(MenuPostReq p);
    List<MenuGetRes> getMenuInfo(MenuGetReq p);
    List<MenuDetailGetRes> getMenuDetailInfo(MenuDetailGetReq p);
    int updateMenuInfo(MenuPutReq p);
    int deleteMenuInfo(MenuDelReq p);
}
