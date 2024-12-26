package com.green.ca2sa.cafe.category.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeCategoryGetReq {
    @Schema(title = "카페 아이디", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long cafeId;
}
