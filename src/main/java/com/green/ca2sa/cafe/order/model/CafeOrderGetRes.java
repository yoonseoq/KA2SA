package com.green.ca2sa.cafe.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeOrderGetRes {
    // order
    private int orderProgress;
    private String memo;
    private String pickUpTime;
    @JsonIgnore
    private long orderId;

    // order_menu
    private int count;

    // menu_option
    // menu와 option에서의 가격 합
    private int sumPrice;
    private String optionName;
}
