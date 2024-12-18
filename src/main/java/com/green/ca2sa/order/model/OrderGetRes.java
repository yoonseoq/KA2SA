package com.green.ca2sa.order.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderGetRes {
    private long orderId;
    private long userId;
    private long cafeId;
    private String location;
    private String pickUpTime;
    private String createdAt;
}
