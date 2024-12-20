package com.green.ca2sa.menu.option;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.menu.model.MenuPostReq;
import com.green.ca2sa.menu.option.model.MenuOptionPostReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("menu/option")
@Tag(name = "메뉴 옵션 관련")
public class MenuOptionController {
    private final MenuOptionService service;

    @PostMapping
    @Operation(summary = "Menu 옵션 등록")
    public ResultResponse<Integer> postMenuOption(@RequestBody MenuOptionPostReq p) {
        Integer result = service.PostMenuOption(p);
        return ResultResponse.<Integer>builder()
                .resultMessage("메뉴 옵션 등록 완료")
                .resultData(result)
                .build();
    }
}
