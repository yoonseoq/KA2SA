package com.green.ca2sa.email;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.green.ca2sa.common.CodeGenerate;
import com.green.ca2sa.common.Constants;
import com.green.ca2sa.email.model.AuthCodeDto;
import com.green.ca2sa.email.model.EmailSendCodeReq;
import com.green.ca2sa.email.model.EmailVerifyCodeReq;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class AuthCodeService {
    private final Cache<String, String> authCodeCache;

    public AuthCodeService() {
        authCodeCache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();
    }

    public AuthCodeDto generateAuthCode(EmailSendCodeReq p) {
        String code = CodeGenerate.generateCode(Constants.getAuth_code_length());
        authCodeCache.put(p.getEmail(), code);
        Date now = new Date();
        String time = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss").format(new Date(now.getTime() + (300_000)));
        return AuthCodeDto.builder().authCode(code).maxDate(time).build();
    }

    public boolean validateAuthCode(EmailVerifyCodeReq p) {
        boolean result = Objects.equals(authCodeCache.getIfPresent(p.getEmail()), p.getCode());
        if (result) {
            authCodeCache.invalidate(p.getEmail());
        }
        return result;
    }
}
