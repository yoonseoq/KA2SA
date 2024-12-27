package com.green.ca2sa.cafe.category;

import com.green.ca2sa.cafe.category.model.CafeCategoryGetReq;
import com.green.ca2sa.cafe.category.model.CafeCategoryGetRes;
import com.green.ca2sa.cafe.category.model.CafeCategoryPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CafeCategoryMapper {
    int postCategoryInfo(CafeCategoryPostReq p);
    int existsCategory(long cafeId, String categoryName);
    List<CafeCategoryGetRes> getMenuCategory(CafeCategoryGetReq p);
}