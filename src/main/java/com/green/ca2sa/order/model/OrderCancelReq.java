package com.green.ca2sa.order.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Schema(title = "주문 취소 요청")
public class OrderCancelReq {
    @Schema(title = "오더 아이디", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long orderId;
    @Schema(title = "해당 소비자 아이디", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long signedUserId;

}
