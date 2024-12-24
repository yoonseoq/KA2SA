package com.green.ca2sa.menu.category;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.menu.category.model.MenuCategoryGetReq;
import com.green.ca2sa.menu.category.model.MenuCategoryGetRes;
import com.green.ca2sa.menu.category.model.MenuCategoryPostReq;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("menu/category")
@RequiredArgsConstructor
@Tag(name = "카테고리 관리")
public class MenuCategoryController {
    private final MenuCategoryService menuCategoryService;
    @PostMapping
    public ResultResponse<Integer> postCategory(@RequestBody MenuCategoryPostReq p) {
        return ResultResponse.<Integer> builder()
                .resultMessage("카테고리 등록 성공")
                .resultData(menuCategoryService.postCategory(p))
                .build();
    }

    @GetMapping
    public ResultResponse<List<MenuCategoryGetRes>> getCategories(@ParameterObject @ModelAttribute MenuCategoryGetReq p) {
        return ResultResponse.<List<MenuCategoryGetRes>>builder()
                .resultMessage("카테고리 조회")
                .resultData(menuCategoryService.getMenuCategory(p))
                .build();
    }
}
