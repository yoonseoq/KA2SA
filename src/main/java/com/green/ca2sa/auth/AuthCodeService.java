package com.green.ca2sa.auth;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.green.ca2sa.auth.model.AuthCodeDto;
import com.green.ca2sa.auth.model.SendEmailAuthCodeReq;
import com.green.ca2sa.auth.model.VerifyEmailAuthCodeReq;
import com.green.ca2sa.common.CodeGenerate;
import com.green.ca2sa.common.Constants;
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
    public AuthCodeDto generateAuthCode(SendEmailAuthCodeReq p) {
        String code = CodeGenerate.generateCode(Constants.getAuth_code_length());
        authCodeCache.put(p.getEmail(), code);
        Date now = new Date();
        String time = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss").format(now);
        return AuthCodeDto.builder().authCode(code).maxDate(time).build();
    }

    public boolean validateAuthCode(VerifyEmailAuthCodeReq p) {
        boolean result = Objects.equals(authCodeCache.getIfPresent(p.getEmail()), p.getCode());
        if (result) {
            authCodeCache.invalidate(p.getEmail());
        }
        return result;
    }
}
