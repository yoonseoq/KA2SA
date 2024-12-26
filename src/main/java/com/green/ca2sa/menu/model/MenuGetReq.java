package com.green.ca2sa.menu.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class MenuGetReq {
    @Schema(title = "카페 ID", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private long cafeId;

}
