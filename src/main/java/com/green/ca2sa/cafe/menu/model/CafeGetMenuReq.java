package com.green.ca2sa.cafe.menu.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
public class CafeGetMenuReq {
    @Schema(name = "cafe_id", requiredMode = Schema.RequiredMode.REQUIRED)
    private long cafeId;
    public CafeGetMenuReq(@BindParam("cafe_id") long cafeId) {
        this.cafeId = cafeId;
    }
}
