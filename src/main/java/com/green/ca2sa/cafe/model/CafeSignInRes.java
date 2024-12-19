package com.green.ca2sa.cafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeSignInRes {
    private long cafeId;
    @JsonIgnore
    private String apw;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String msg;
}
