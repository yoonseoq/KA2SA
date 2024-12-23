package com.green.ca2sa.cafe.menu.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jdbc.SchemaManagement;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
public class CafeGetOptionReq {
    @Schema(name = "menu_id",requiredMode = Schema.RequiredMode.REQUIRED)
    private long menuId;

    public CafeGetOptionReq(@BindParam("menu_id") long menuId) {
        this.menuId = menuId;
    }
}
