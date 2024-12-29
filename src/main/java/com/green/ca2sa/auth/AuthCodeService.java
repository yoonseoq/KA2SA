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

//이메일 코드를 생성하고 검증하는 기능을 제공, Google 의 Guava Cache 를 활용하여 인증 코드를 일정 시간 동안 저장하고 관리
public class AuthCodeService {
    private final Cache<String, String> authCodeCache; //cache(email, code)

    public AuthCodeService() {
        authCodeCache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();
    // authCodeCache 는 이메일 주소를 키로 사용하여 인증코드를 값으로 저장
    // expireAfterWrite 설정으로 해당 데이터는 작성후 5분경과후 자동으로 삭제
    }
    public AuthCodeDto generateAuthCode(SendEmailAuthCodeReq p) { // email만 입력하묜 authCodeDto 타입으로 반환
        String code = CodeGenerate.generateCode(Constants.getAuth_code_length()); // 설정한 길이로 코드길이 설정
        authCodeCache.put(p.getEmail(), code); // 인증코드를 이렇게 캐시로 저장
        Date now = new Date();
        String time = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss").format(now);
        // 현재 시간 포맷팅하여 만료시간을 문자열로 설정
        return AuthCodeDto.builder().authCode(code).maxDate(time).build();
    }

    // 입력된 입력코드가 캐시에 저장된 코드와 일치하는지 검증. 검증이 성공하면 해당 캐시 데이터를 제거
    public boolean validateAuthCode(VerifyEmailAuthCodeReq p) {
        boolean result = Objects.equals(authCodeCache.getIfPresent(p.getEmail()), p.getCode());
                        // getIfPresent(p.getEmail()) 로 캐시에서 해당메일의 인증코드를 조회, 그리고 받은 인증코드와 비교
        if (result) {
            authCodeCache.invalidate(p.getEmail()); //동일하면 해당데이터를 제거함
        }
        return result;
    }
}
