package com.green.ca2sa.auth.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCodeDto {
    private String authCode; // 인증코드
    private String maxDate; // 만료시간
}
