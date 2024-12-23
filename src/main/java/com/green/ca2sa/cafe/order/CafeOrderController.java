package com.green.ca2sa.cafe.order;

import com.green.ca2sa.cafe.order.model.CafeOrderPutReq;
import com.green.ca2sa.common.model.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("cafe/order")
public class CafeOrderController {
    private final CafeOrderService cafeOrderService;

    @PatchMapping()
    @Operation(summary = "카페 주문상태 수정")
    public ResultResponse<Integer> patchCafeOrder( CafeOrderPutReq p){
        int result = cafeOrderService.updCafeOrder(p);
        return ResultResponse.<Integer>builder()
                .resultMessage(result == 0 ? "변경실패" : "변경완료")
                .resultData(result)
                .build();
    }
}
