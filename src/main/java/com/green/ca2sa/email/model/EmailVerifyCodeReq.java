package com.green.ca2sa.email.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmailVerifyCodeReq {
    @Schema(title = "인증받을 이메일", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(title = "인증번호", requiredMode = Schema.RequiredMode.REQUIRED)
    private String code;
}
