package com.green.ca2sa.cafe.model;

import com.green.ca2sa.common.model.Paging;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeOrderGetReq extends Paging {
    private long cafeId;

    public CafeOrderGetReq(Integer page, Integer size, long cafeId) {
        super(page, size);
        this.cafeId = cafeId;
    }
}
