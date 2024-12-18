package com.green.ca2sa.user;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.user.model.UserSignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService service;


    @PostMapping("sign-up")
    public ResultResponse<Integer> postUser(@RequestBody UserSignUpReq p){
        int result=service.postUser(p);

        return ResultResponse.<Integer>builder()
                .resultMessage("회원가입완료")
                .resultData(result)
                .build();
    }

    @GetMapping("check-email")
    public ResultResponse<Integer> getUserEmailCheck(@RequestParam String email){
        int result=service.getUserEmailCheck(email);

        return ResultResponse.<Integer>builder()
                .resultData(result)
                .resultMessage(result==0?"존재하는 이메일 입니다":"이메일 인증해주세요")
                .build();

    }

}
