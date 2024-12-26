package com.green.ca2sa.cafe.category;

import com.green.ca2sa.cafe.category.model.CafeCategoryGetReq;
import com.green.ca2sa.cafe.category.model.CafeCategoryGetRes;
import com.green.ca2sa.cafe.category.model.CafeCategoryPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeCategoryService {
    private final CafeCategoryMapper CategoryMapper;

    public int postCategoryInfo(CafeCategoryPostReq p) {
        int exists = CategoryMapper.existsCategory(p.getCafeId(), p.getCategoryName());
        if (exists > 0) {
            throw new IllegalArgumentException("이미 존재하는 카테고리입니다.");
        }
        return CategoryMapper.postCategoryInfo(p);
    }

    public List<CafeCategoryGetRes> getMenuCategory(CafeCategoryGetReq p) {
        return CategoryMapper.getMenuCategory(p);
    }
}
