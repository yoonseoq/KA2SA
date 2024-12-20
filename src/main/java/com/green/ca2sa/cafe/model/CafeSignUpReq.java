package com.green.ca2sa.cafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeSignUpReq {
    private String cafeName;
    private String location;
    private String tel;
    @Schema(defaultValue = "22:00:00")
    private String closeTime;
    @Schema(defaultValue = "09:00:00")
    private String openTime;
    private String email;
    private String apw;
    private String businessNumber;
    private int agree;
    @JsonIgnore
    private String cafePic;
    @JsonIgnore
    private long cafeId;
}
