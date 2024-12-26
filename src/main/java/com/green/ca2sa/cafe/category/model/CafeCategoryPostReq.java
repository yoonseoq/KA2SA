package com.green.ca2sa.cafe.category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeCategoryPostReq {
    private long cafeId;
    private String categoryName;
}
