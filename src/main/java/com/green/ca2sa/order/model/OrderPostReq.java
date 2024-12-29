package com.green.ca2sa.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.ca2sa.order.orderMenu.model.OrderMenuPostReq;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderPostReq {
    @JsonIgnore
    private long orderId;

    @Schema(title = "픽업 시간", example = "00:00:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private String pickUpTime;
    @Schema(title = "요청사항", example = "저희아이가 먹을거라서요 @@낭낭하게 챙겨주세요")
    private String memo;
    @Schema(title = "소비자 아이디", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;
    @Schema(title = "카페 아이디", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long cafeId;
    @Schema(title = "주문 메뉴 리스트", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<OrderMenuPostReq> menuList;
}
