package com.green.ca2sa.menu;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.menu.model.MenuDelReq;
import com.green.ca2sa.menu.model.MenuPostReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("menu")
public class MenuController {
    private final MenuService service;

    @PostMapping
    @Operation(summary = "Menu 등록")
    public ResultResponse<Integer> postMenu(@RequestPart MultipartFile pic, @RequestPart MenuPostReq p) {
        Integer result = service.postMenu(pic, p);
        return ResultResponse.<Integer>builder()
                             .resultMessage("메뉴 등록 완료")
                             .resultData(result)
                             .build();
    }

    @DeleteMapping
    @Operation(summary = "Menu 삭제", description = "메뉴의 옵션 모두 삭제 처리")
    public ResultResponse<Integer> deleteMenu(@ParameterObject @ModelAttribute MenuDelReq p) {
        Integer result = service.deleteMenu(p);
        return ResultResponse.<Integer>builder()
                             .resultMessage("메뉴 삭제 완료")
                             .resultData(result)
                             .build();
    }
}
