package com.green.ca2sa.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoPutReq {
    @Schema(title = "유저 ID",example = "2",requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;
    @Schema(title = "이메일",example = "yaho@gmail.com",requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(title = "비밀번호",example = "1111",requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    @Schema(title = "닉네임",example = "홍길동")
    private String nickName;
    @Schema(title = "휴대폰번호",example = "01012345678",requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;
}
