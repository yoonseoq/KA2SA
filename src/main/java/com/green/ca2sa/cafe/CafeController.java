package com.green.ca2sa.cafe;

import com.green.ca2sa.cafe.model.CafeGetReq;
import com.green.ca2sa.cafe.model.CafeGetRes;
import com.green.ca2sa.cafe.model.CafeOrderPutReq;
import com.green.ca2sa.cafe.model.CafePutReq;
import com.green.ca2sa.common.model.ResultResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
@Slf4j
@Tag(name = "카페 관련")
public class CafeController {
    private final CafeService cafeService;


    @GetMapping
    public ResultResponse<CafeGetRes> getCafe(CafeGetReq p) {
        CafeGetRes res = cafeService.selCafe(p);
        return ResultResponse.<CafeGetRes>builder()
                .resultData(res)
                .resultMessage("조회")
                .build();
    }

    @PatchMapping
    public ResultResponse<Integer> patchCafe(@RequestBody CafePutReq p){
        log.info("p 값 {}",p);
        int result = cafeService.updCafe(p);
        return ResultResponse.<Integer>builder()
                .resultData(result)
                .resultMessage(result == 0 ? "수정 실패" : "수정 완료")
                .build();
    }

    @PatchMapping("/order")
    public ResultResponse<Integer> patchCafeOrder(CafeOrderPutReq p){
        int result = cafeService.updCafeOrder(p);
        return ResultResponse.<Integer>builder()
                .resultMessage("")
                .resultData(result)
                .build();
    }
}
