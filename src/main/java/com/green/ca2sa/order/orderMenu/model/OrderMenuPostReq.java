package com.green.ca2sa.order.orderMenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderMenuPostReq {
    @JsonIgnore
    private long orderId;

    @Schema(title = "메뉴 아이디", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long menuId;
    @Schema(title = "주문 개수", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int count;
    @Schema(title = "옵션")
    private List<OrderMenuOptionPostReq> options;

    @JsonIgnore
    private long orderMenuId;
}
