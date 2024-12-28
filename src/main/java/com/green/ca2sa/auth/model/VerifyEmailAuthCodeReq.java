package com.green.ca2sa.auth.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VerifyEmailAuthCodeReq {
    @NotNull
    @Email(message = "이메일 형식이 다릅니다")
    @Schema(title = "인증받을 이메일", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotNull
    @Schema(title = "인증 번호", requiredMode = Schema.RequiredMode.REQUIRED)
    private String code;

}
