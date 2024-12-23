package com.green.ca2sa.order;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.order.model.OrderCancelReq;
import com.green.ca2sa.order.model.OrderGetReq;
import com.green.ca2sa.order.model.OrderGetRes;
import com.green.ca2sa.order.model.OrderPostReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("order")
@Tag(name = "주문 관련")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @Operation(description = "주문 하기")
    public ResultResponse<Integer> postOrder(@RequestBody OrderPostReq p) {
        int result = orderService.PostOrder(p);
        log.info("OrderController > postOrder > req: {}", p);
        return ResultResponse.<Integer>builder()
                .resultMessage("주문 등록 완료")
                .resultData(result)
                .build();
    }

    @GetMapping
    @Operation(description = "주문 확인")
    public ResultResponse<List<OrderGetRes>> getOrderList(@ParameterObject @ModelAttribute OrderGetReq p) {
        List<OrderGetRes> list = orderService.GetOrderList(p);
        return ResultResponse.<List<OrderGetRes>>builder()
                .resultMessage("주문 조회 완료")
                .resultData(list)
                .build();
    }

    @PatchMapping
    @Operation(description = "주문 취소 신청")
    public ResultResponse<Integer> cancelOrder(@ParameterObject @ModelAttribute OrderCancelReq p){
        log.info("OrderController > cancelOrder > req: {}", p);
        return ResultResponse.<Integer>builder()
                .resultMessage("주문 취소 신청 완료")
                .resultData(orderService.cancelOrder(p))
                .build();
    }


}
