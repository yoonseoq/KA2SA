package com.green.ca2sa.cafe.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CafePutReq {
    private String cafeName;
    private String location;
    private String tel;
    private String cafePic;
    private String closeTime;
    private String openTime;
    private long cafeId;
}
