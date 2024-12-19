package com.green.ca2sa.order.orderMenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderMenuPostReq {

    private Long orderId;
    private long menuId;
    private int count;
    private List<OrderMenuOptionPostReq> options;

    @JsonIgnore
    private Long orderMenuId;

    public OrderMenuPostReq() {
        super();
        orderId = 0L;
    }
}
