package com.green.ca2sa.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserSignUpReq {

    @Schema(title = "유저 email",requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(title = "유저 비밀번호",requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    @Schema(title = "유저 닉네임")
    private String nickName;
    @Schema(title = "약관 동의",requiredMode = Schema.RequiredMode.REQUIRED)
    private int agree;

}
