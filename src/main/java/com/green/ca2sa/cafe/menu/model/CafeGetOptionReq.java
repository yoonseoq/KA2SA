package com.green.ca2sa.cafe.menu.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jdbc.SchemaManagement;

@Getter
@Setter
public class CafeGetOptionReq {
    @Schema(title = "메뉴 PK")
    private long menuId;
}
