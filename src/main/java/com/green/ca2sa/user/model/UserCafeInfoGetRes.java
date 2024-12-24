package com.green.ca2sa.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCafeInfoGetRes {
    private long cafeId;
    private String cafeName;
    private String cafePic;
    private String location;
}
