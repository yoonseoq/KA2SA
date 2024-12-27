package com.green.ca2sa.user;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "회원 관리")

public class UserController {
    private final UserService service;


    @PostMapping("sign-up")
    @Operation(summary = "회원가입")
    public ResultResponse<Integer> postUserSignUp(@RequestBody UserSignUpReq p){
        int result=service.postUserSignUp(p);

        return ResultResponse.<Integer>builder()
                .resultMessage("회원가입완료")
                .resultData(result)
                .build();
    }

    @GetMapping("check-mail")
    public ResultResponse<Integer> checkMail(@RequestParam("mail") String mail){
        int result=service.getEmailCheck(mail);

       return ResultResponse.<Integer>builder()
               .resultMessage(result == 0? "존재하는 이메일 입니다": "이메일을 인증해 주세요")
               .resultData(result)
               .build();
    }
}
