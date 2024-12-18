package com.green.ca2sa.cafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CafeSignInReq {
    private String apw;
    private String email;

}
