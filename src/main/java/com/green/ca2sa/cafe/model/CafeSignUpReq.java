package com.green.ca2sa.cafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeSignUpReq {
    private String cafeName;
    private String location;
    private String tel;
    private String cafePic;
    private String closeTime;
    private String openTime;
    private String email;
    private String apw;
    private String businessNumber;
    private int agree;
    @JsonIgnore
    private String msg;
}
