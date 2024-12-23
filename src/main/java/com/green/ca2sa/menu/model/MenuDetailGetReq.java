package com.green.ca2sa.menu.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDetailGetReq {
    @Schema(title = "메뉴 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long menuId;
//    @Schema(title = "카페 ID", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
//    private long cafeId;

}
