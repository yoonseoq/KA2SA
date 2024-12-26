package com.green.ca2sa.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuPostReq {
    @Schema(title = "메뉴 PK", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long cafeId;
    @Schema(title = "메뉴 이름", example = "아메리카노", requiredMode = Schema.RequiredMode.REQUIRED)
    private String menuName;
    @Schema(title = "메뉴 가격", example = "2000", requiredMode = Schema.RequiredMode.REQUIRED)
    private long price;
    @Schema(title = "메뉴 설명", example = "진하고 고소한 커피")
    private String comment;

    private long categoryId;
    @JsonIgnore
    private long menuId;
    @JsonIgnore
    private String menuPic;

}