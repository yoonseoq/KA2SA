package com.green.ca2sa.order.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderDelReq {
    private long orderId;
    private String reason; // 왜 취소 했는지?
}
