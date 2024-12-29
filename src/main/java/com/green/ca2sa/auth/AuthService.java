package com.green.ca2sa.auth;

import com.green.ca2sa.auth.model.AuthCodeDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class AuthService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public boolean sendCodeToEmail(String to, String subject, AuthCodeDto authCodeDto) {
                                // 이메일 수신자 주소, 이메일 제목, 인증코드 및 만료시간 정보
        MimeMessage mimeMessage = mailSender.createMimeMessage(); // 이메일 메세지 객체
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage,true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(getHtmlTemplate(authCodeDto),true);
            mailSender.send(mimeMessage);
            return true;
        } catch (MessagingException e){
            log.error(e.getMessage());
            return false;
        }
    }

    private String getHtmlTemplate(AuthCodeDto authCodeDto) {
        return templateEngine.process("emailTemplate",getConText(authCodeDto));
    }

    private Context getConText(AuthCodeDto authCodeDto) {
        Map<String, Object> dto = new HashMap<>(2);
        dto.put("authCode", authCodeDto.getAuthCode());
        dto.put("maxDate", authCodeDto.getMaxDate());
        Context context = new Context();
        context.setVariables(dto);
        return context;
    }
}
