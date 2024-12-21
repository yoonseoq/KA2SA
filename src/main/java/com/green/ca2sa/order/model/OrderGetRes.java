package com.green.ca2sa.order.model;

import com.green.ca2sa.order.orderMenu.model.OrderMenuDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderGetRes {
    private long orderId;
    private String nickName;
    private long cafeName;
    private String location;
    private String pickUpTime;
    private String createdAt;

    private List<OrderMenuDto> orderMenuList;
}
