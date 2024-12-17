package com.green.ca2sa.email;

import com.green.ca2sa.common.CodeGenerate;
import com.green.ca2sa.common.Constants;
import com.green.ca2sa.email.model.EmailSendCodeReq;
import com.green.ca2sa.email.model.EmailVerifyCodeReq;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthCodeService {
    private final Map<String, String> authCodeMap;

    public AuthCodeService() {
        authCodeMap = new HashMap<>();
    }

    public String generateAuthCode(EmailSendCodeReq p) {
        String code = CodeGenerate.generateCode(Constants.getAuth_code_length());
        authCodeMap.put(p.getEmail(), code);
        return code;
    }

    public boolean validateAuthCode(EmailVerifyCodeReq p) {
        boolean result = authCodeMap.containsKey(p.getEmail()) && authCodeMap.get(p.getEmail()).equals(p.getCode());
        authCodeMap.remove(p.getEmail());
        return result;
    }
}
