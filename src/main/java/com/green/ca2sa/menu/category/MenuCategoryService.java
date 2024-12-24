package com.green.ca2sa.menu.category;

import com.green.ca2sa.menu.category.model.MenuCategoryGetReq;
import com.green.ca2sa.menu.category.model.MenuCategoryGetRes;
import com.green.ca2sa.menu.category.model.MenuCategoryPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuCategoryService {
    private final MenuCategoryMapper menuCategoryMapper;

    public int postCategory(MenuCategoryPostReq p) {
        return menuCategoryMapper.insCategory(p);
    }

    public List<MenuCategoryGetRes> getMenuCategory(MenuCategoryGetReq p) {
        return menuCategoryMapper.getMenuCategory(p);
    }
}
