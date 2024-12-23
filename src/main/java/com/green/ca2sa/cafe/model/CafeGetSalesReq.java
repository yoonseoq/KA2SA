package com.green.ca2sa.cafe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
public class CafeGetSalesReq {
    @Schema(name = "days_ago")
    private String daysAgo;
    @Schema(name = "cafe_id")
    private long cafeId;
    @Schema(name = "order_progress", title = "주문 상태"
            , description ="0:주문확인, 1:준비중, 2:준비완료, 3: 수령완료, 4: 주문거절, 5: 주문 취소 요청 6: 주문 취소 확인")
    private int orderProgress;
    private String today;

    public CafeGetSalesReq(@BindParam("days_ago") String daysAgo, @BindParam("cafe_id") long cafeId,
                           @BindParam("order_progress")int orderProgress, String today) {
        this.daysAgo = daysAgo;
        this.cafeId = cafeId;
        this.orderProgress = orderProgress;
        this.today = today;
    }
}
