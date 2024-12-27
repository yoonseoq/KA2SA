package com.green.ca2sa.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserInfoPutReq {
    private String email;
    private String upw;
    private String nickName;
}
