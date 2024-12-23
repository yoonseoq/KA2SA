package com.green.ca2sa.order.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderCancelReq {

    private long orderId;
    private long signedUserId;

}
