package com.green.ca2sa.email;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.email.model.EmailSendCodeReq;
import com.green.ca2sa.email.model.EmailVerifyCodeReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("email-auth")
public class EmailController {
    private final EmailService emailService;
    private final AuthCodeService authCodeService;

    @PostMapping("send-code")
    public ResultResponse<Boolean> sendCode(@RequestBody EmailSendCodeReq p) {
        String code = authCodeService.generateAuthCode(p);
        boolean result = emailService.sendCodeToEmail(p.getEmail(), "이메일 인증 코드", code);
        return ResultResponse.<Boolean>builder()
                .resultMessage(String.format("전송 %s", result ? "성공" : "실패"))
                .resultData(result)
                .build();
    }

    @PostMapping("verify-code")
    public ResultResponse<Boolean> verifyCode(@RequestBody EmailVerifyCodeReq p) {
        boolean result = authCodeService.validateAuthCode(p);
        return ResultResponse.<Boolean>builder()
                .resultMessage(String.format("인증 %s", result ? "성공" : "실패"))
                .resultData(result)
                .build();
    }
}
