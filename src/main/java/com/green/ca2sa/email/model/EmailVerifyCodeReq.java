package com.green.ca2sa.email.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmailVerifyCodeReq {
    private String email;
    private String code;
}
