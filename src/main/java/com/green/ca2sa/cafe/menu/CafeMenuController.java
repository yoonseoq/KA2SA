package com.green.ca2sa.cafe.menu;


import com.green.ca2sa.cafe.menu.model.CafeGetMenuReq;
import com.green.ca2sa.cafe.menu.model.CafeGetMenuRes;
import com.green.ca2sa.cafe.menu.model.CafeGetOptionReq;
import com.green.ca2sa.cafe.menu.model.CafeGetOptionRes;
import com.green.ca2sa.cafe.order.model.CafeOrderGetReq;
import com.green.ca2sa.cafe.order.model.CafeOrderGetRes;
import com.green.ca2sa.common.model.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("cafe/menu")
public class CafeMenuController {
    private final CafeMenuService cafeMenuService;

    @GetMapping
    public ResultResponse<List<CafeGetMenuRes>> getCafeMenu(@ParameterObject CafeGetMenuReq p) {
        List<CafeGetMenuRes> res = cafeMenuService.selCafeMenu(p);
        return ResultResponse.<List<CafeGetMenuRes>>builder()
                .resultMessage("조회 완료")
                .resultData(res)
                .build();
    }

    @GetMapping("option")
    public ResultResponse<List<CafeGetOptionRes>> getCafeOption(@ParameterObject CafeGetOptionReq p) {
     List<CafeGetOptionRes> res = cafeMenuService.selCafeMenuOption(p);

     return ResultResponse.<List<CafeGetOptionRes>>builder()
             .resultMessage("조회 완료")
             .resultData(res)
             .build();
    }
}
