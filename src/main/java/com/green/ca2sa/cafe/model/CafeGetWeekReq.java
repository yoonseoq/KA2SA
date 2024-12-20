package com.green.ca2sa.cafe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeGetWeekReq {
    private String daysAgo;
    private long cafeId;
    private int orderProgress;
    private String toDay;
}
