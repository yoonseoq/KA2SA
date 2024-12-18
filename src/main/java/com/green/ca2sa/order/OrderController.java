package com.green.ca2sa.order;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.order.model.OrderPostReq;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    public ResultResponse<Integer> postOrder(OrderPostReq p) {
        int result = orderService.PostOrder(p);
        log.info("OrderController > postOrder > req: {}", p);
        return ResultResponse.<Integer>builder()
                .resultMessage("주문등록완료")
                .resultData(result)
                .build();
    }
}
