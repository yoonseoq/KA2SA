package com.green.ca2sa.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserSignUpReq {


    private String email;
    private String upw;
    private String nickName;
    private int agree;

}
