package com.green.ca2sa.cafe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class CafeGetAllReq {
    @Schema(name = "user_latitude")
    private double userLatitude;
    @Schema(name = "user_longitude")
    private double userLongitude;
    @ConstructorProperties({"user_latitude","user_longitude"})
    public CafeGetAllReq(double userLatitude, double userLongitude) {
        this.userLatitude = userLatitude;
        this.userLongitude = userLongitude;
    }
}
