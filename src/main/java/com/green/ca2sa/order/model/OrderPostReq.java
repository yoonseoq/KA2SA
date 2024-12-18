package com.green.ca2sa.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderPostReq {
    @JsonIgnore
    private long orderId;

    private long userId;
    private long cafeId;
    private String pickUpTime;
    private String memo;

}
