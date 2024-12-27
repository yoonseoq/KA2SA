package com.green.ca2sa.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInReq {
    @Schema(title = "유저 email",requiredMode = Schema.RequiredMode.REQUIRED)
    String email;
    @Schema(title = "유저 비밀번호",requiredMode = Schema.RequiredMode.REQUIRED)
    String upw;
}
