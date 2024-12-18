package com.green.ca2sa.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpReq {
    private String email;
    private String upw;
    private String nickName;
    private String phone;
    private int agree;
}
