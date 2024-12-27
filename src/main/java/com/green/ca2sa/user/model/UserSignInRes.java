package com.green.ca2sa.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInRes {
    private long userId;
    private String username;

    @JsonIgnore
    private String message;
    @JsonIgnore
    private String upw;
}
