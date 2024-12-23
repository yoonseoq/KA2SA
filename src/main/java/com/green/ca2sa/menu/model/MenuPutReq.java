package com.green.ca2sa.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuPutReq {
//    @Schema(title = "카페 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
//    private long cafeId;
    @Schema(title = "메뉴 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long menuId;
    @Schema(title = "메뉴 이름", example = "아메리카노", requiredMode = Schema.RequiredMode.REQUIRED)
    private String menuName;
    @Schema(title = "가격", example = "2000", requiredMode = Schema.RequiredMode.REQUIRED)
    private int price;
    @Schema(title = "메뉴 설명", example = "진하고 고소한 커피")
    private String comment;

    @JsonIgnore
    private String menuPic;
}