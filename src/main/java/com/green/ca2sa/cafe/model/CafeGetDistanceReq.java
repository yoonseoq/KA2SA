package com.green.ca2sa.cafe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class CafeGetDistanceReq {
    @Schema(name="cafe_id")
    private long cafeId;
    @Schema(name="user_latitude")
    private double userLatitude;
    @Schema(name="user_longitude")
    private double userLongitude;
    @ConstructorProperties({"cafe_id", "user_latitude", "user_longitude"})
    public CafeGetDistanceReq(long cafeId, double userLatitude, double longitude) {
        this.cafeId = cafeId;
        this.userLatitude = userLatitude;
        this.userLongitude = longitude;
    }
}
