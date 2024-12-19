package com.green.ca2sa.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "유저 로그인 응답")
public class UserSingInRes {
    private long userId;
    private String nickName;
    private String email;
    @JsonIgnore
    private String upw;
    @JsonIgnore
    private String message;
}
