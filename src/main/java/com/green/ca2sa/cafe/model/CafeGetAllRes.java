package com.green.ca2sa.cafe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeGetAllRes {
    private String cafeName;
    private String location;
    private String tel;
    private String cafePic;
    private String openTime;
    private String closeTime;
    private int distance;
    private double latitude;
    private double longitude;
    private long cafeId;
}
