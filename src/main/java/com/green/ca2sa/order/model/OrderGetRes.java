package com.green.ca2sa.order.model;

import com.green.ca2sa.order.orderMenu.model.OrderMenuDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@ToString
public class OrderGetRes {
    private long orderId;
    private String nickName;
    private String cafeName;
    private String location;
    private String pickUpTime;
    private String createdAt;
    private String memo;

    private List<OrderMenuDto> orderMenuList;
}
