package com.green.ca2sa.menu;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.menu.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("menu")
public class MenuController {
    private final MenuService service;

    @PostMapping
    @Operation(summary = "Menu 등록하기")
    public ResultResponse<Integer> postMenuInfo(@RequestPart MultipartFile pic, @RequestPart MenuPostReq p) {
        Integer result = service.postMenuInfo(pic, p);
        return ResultResponse.<Integer>builder()
                             .resultMessage("메뉴 등록 완료")
                             .resultData(result)
                             .build();
    }

    @GetMapping
    @Operation(summary = "Menu 가져오기")
    public ResultResponse<List<MenuGetRes>> getMenuInfo(@ParameterObject @ModelAttribute MenuGetReq p) {
        List<MenuGetRes> result = service.getMenuInfo(p);
        return ResultResponse.<List<MenuGetRes>>builder()
                             .resultMessage("메뉴 출력 완료")
                             .resultData(result)
                             .build();
    }

    @PutMapping
    @Operation(summary = "Menu 수정하기")
    public ResultResponse<Integer> updateMenuInfo(@RequestPart(required = false) MultipartFile pic, @RequestPart MenuPutReq p) {
        int result = service.updateMenuInfo(pic, p);
        return ResultResponse.<Integer>builder()
                .resultMessage("메뉴 수정 완료")
                .resultData(result)
                .build();
    }

    @DeleteMapping
    @Operation(summary = "Menu 삭제하기", description = "메뉴의 옵션 모두 삭제 처리")
    public ResultResponse<Integer> deleteMenuInfo(@ParameterObject @ModelAttribute MenuDelReq p) {
        Integer result = service.deleteMenuInfo(p);
        return ResultResponse.<Integer>builder()
                             .resultMessage("메뉴 삭제 완료")
                             .resultData(result)
                             .build();
    }
}