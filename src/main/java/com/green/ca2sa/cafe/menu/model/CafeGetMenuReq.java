package com.green.ca2sa.cafe.menu.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeGetMenuReq {
    @Schema(title = "카페 pk")
    private long cafeId;
}
