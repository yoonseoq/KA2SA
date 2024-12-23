package com.green.ca2sa.cafe.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CafeGetSalesRes {
    private List<CafeGetSalesDto> selWeek;
    private int weekSumPrice;
}
