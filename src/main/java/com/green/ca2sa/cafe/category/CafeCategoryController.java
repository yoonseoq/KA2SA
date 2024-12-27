package com.green.ca2sa.cafe.category;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.cafe.category.model.CafeCategoryGetReq;
import com.green.ca2sa.cafe.category.model.CafeCategoryGetRes;
import com.green.ca2sa.cafe.category.model.CafeCategoryPostReq;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cafe/category")
@RequiredArgsConstructor
@Tag(name = "카테고리 관리")
public class CafeCategoryController {
    private final CafeCategoryService menuCategoryService;

    @PostMapping
    public ResultResponse<Integer> postCategoryInfo(@RequestBody CafeCategoryPostReq p) {
        try {
            return ResultResponse.<Integer>builder()
                    .resultMessage("카테고리 등록 완료")
                    .resultData(menuCategoryService.postCategoryInfo(p))
                    .build();
        } catch (IllegalArgumentException e) {
            return  ResultResponse.<Integer>builder()
                    .resultMessage(e.getMessage())
                    .build();
        }
    }

    @GetMapping
    public ResultResponse<List<CafeCategoryGetRes>> getCategories(@ParameterObject @ModelAttribute CafeCategoryGetReq p) {
        return ResultResponse.<List<CafeCategoryGetRes>>builder()
                .resultMessage("카테고리 조회 완료")
                .resultData(menuCategoryService.getMenuCategory(p))
                .build();
    }
}