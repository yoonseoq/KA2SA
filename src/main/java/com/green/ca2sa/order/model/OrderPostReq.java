package com.green.ca2sa.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.ca2sa.order.orderMenu.model.OrderMenuPostReq;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderPostReq {
    @JsonIgnore
    private long orderId;
    private String pickUpTime;
    private String memo;
    private long userId;
    private long cafeId;
    private List<OrderMenuPostReq> menuList;
    // order에서 받아와야 되는 것





}
