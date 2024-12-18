package com.green.ca2sa.email;

import com.green.ca2sa.common.model.ResultResponse;
import com.green.ca2sa.email.model.EmailSendCodeReq;
import com.green.ca2sa.email.model.EmailVerifyCodeReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("email-auth")
@Tag(name = "이메일 인증")
public class EmailController {
    private final EmailService emailService;
    private final AuthCodeService authCodeService;

    @PostMapping("send-code")
    @Operation(description = "이메일 인증 코드 발송")
    public ResultResponse<Boolean> postSendCode(@RequestBody EmailSendCodeReq p) {
        String code = authCodeService.generateAuthCode(p);
        boolean result = emailService.sendCodeToEmail(p.getEmail(), "이메일 인증 코드", code);
        return ResultResponse.<Boolean>builder()
                .resultMessage(String.format("전송 %s", result ? "성공" : "실패"))
                .resultData(result)
                .build();
    }

    @PostMapping("verify-code")
    @Operation(description = "이메일 인증 코드 검사")
    public ResultResponse<Boolean> postVerifyCode(@RequestBody EmailVerifyCodeReq p) {
        boolean result = authCodeService.validateAuthCode(p);
        return ResultResponse.<Boolean>builder()
                .resultMessage(String.format("인증 %s", result ? "성공" : "실패"))
                .resultData(result)
                .build();
    }
}
