package com.green.ca2sa.cafe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeCheckEmailPostReq {
    @Schema(title = "이메일",requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
}
