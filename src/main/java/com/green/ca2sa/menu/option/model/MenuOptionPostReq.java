package com.green.ca2sa.menu.option.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuOptionPostReq {
    @JsonIgnore
    private long menuOptionId;

    private long menuId;
    @Schema(title = "옵션 이름", example = "아이스", requiredMode = Schema.RequiredMode.REQUIRED)
    private String optionName;
    @Schema(title = "옵션 가격", example = "500", requiredMode = Schema.RequiredMode.REQUIRED)
    private int addPrice;
    @Schema(title = "필수 옵션", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int required;
}
