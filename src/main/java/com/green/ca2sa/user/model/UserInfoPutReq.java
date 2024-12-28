package com.green.ca2sa.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter


public class UserInfoPutReq {
    @Schema(title = "유저 ID",requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;
    @Schema(title = "유저 비밀번호",requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    @Schema(title = "유저 닉네임")
    private String nickName;
}
