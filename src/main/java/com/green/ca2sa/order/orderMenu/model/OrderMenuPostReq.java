package com.green.ca2sa.order.orderMenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class OrderMenuPostReq {
    private long orderId;
    private long menuId;
    private int count;

    @JsonIgnore
    private long orderMenuId;
}
