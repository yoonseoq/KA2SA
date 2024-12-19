package com.green.ca2sa.email.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCodeDto {
    private String authCode;
    private String maxDate;
}
