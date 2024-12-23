package com.green.ca2sa.order.orderMenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderMenuOptionPostReq {
    @JsonIgnore
    private long orderMenuId;
    private long menuOptionId;
}
