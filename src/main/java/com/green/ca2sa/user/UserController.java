package com.green.ca2sa.user;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Slf4j
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

    @GetMapping("check-email")
    @Operation(summary = "이메일 중복 확인")
    public ResultResponse<Integer> getUserEmailCheck(@RequestParam String email){
        int result=service.getUserEmailCheck(email);

        return ResultResponse.<Integer>builder()
                .resultData(result)
                .resultMessage(result==0?"존재하는 이메일 입니다":"이메일 인증해주세요")
                .build();
    }

    @PostMapping("sign-in")
    @Operation(summary = "로그인")
    public ResultResponse<UserSingInRes> postUserSignIn(@RequestBody UserSignInReq p){
        UserSingInRes res=service.postUserSingIn(p);


        return ResultResponse.<UserSingInRes>builder()
                .resultMessage(res.getMessage())
                .resultData(res)
                .build();
    }

    @GetMapping("info")
    @Operation(summary = "회원정보 확인")
    public ResultResponse<UserInfoGetRes> getUserInfo(@RequestParam long userId){
        UserInfoGetRes res= service.getUserInfo(userId);

        return ResultResponse.<UserInfoGetRes>builder()
                .resultMessage(res==null?"회원정보가 없습니다":"회원 정보 조회 완료")
                .resultData(res)
                .build();
    }

    @PutMapping("info")
    @Operation(summary = "회원정보 수정")
    public ResultResponse<Integer> updateUserInfo(@ParameterObject @ModelAttribute UserInfoPutReq p){
        int result=service.updateUserInfo(p);

        return ResultResponse.<Integer>builder()
                .resultMessage("회원정보 수정 완료")
                .resultData(result)
                .build();
    }

    @DeleteMapping
    @Operation(summary = "회원정보 삭제")
    public ResultResponse<Integer> deleteUserInfo(@RequestParam long userId){
        int result=service.deleteUserInfo(userId);

        return ResultResponse.<Integer>builder()
                .resultMessage("회원정보 삭제 완료")
                .resultData(result)
                .build();

    }








}
