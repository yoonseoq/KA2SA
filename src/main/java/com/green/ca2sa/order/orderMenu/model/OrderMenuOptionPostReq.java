package com.green.ca2sa.order.orderMenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderMenuOptionPostReq {
    @JsonIgnore
    private long orderMenuId;
    @Schema(title = "메뉴 옵션 PK", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long menuOptionId;
}
