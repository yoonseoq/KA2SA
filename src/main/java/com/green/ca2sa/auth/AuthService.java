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

    // 이메일 호출시 수신자 주소, 제목, 인증코드정보  authCodeDto 를 전달
    public boolean sendCodeToEmail(String to, String subject, AuthCodeDto authCodeDto) {
                                // 이메일 수신자 주소, 이메일 제목, 인증코드 및 만료시간 정보
        MimeMessage mimeMessage = mailSender.createMimeMessage(); // 이메일 메세지 객체
        MimeMessageHelper helper; //HTML, 첨부파일 등 고급 기능을 간편히 사용하도록 도와주는 유틸리티 클래스. 메세지 설정 객체
        try {
            helper = new MimeMessageHelper(mimeMessage,true); //HTML 형식으로 텍스트를 설정
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(getHtmlTemplate(authCodeDto),true); //밑에 메소드부터 타고 타고 와서 메일구성설정
            mailSender.send(mimeMessage);// 메일 보내버림
            return true;
        } catch (MessagingException e){
            log.error(e.getMessage());
            return false;
        }
    }

    private String getHtmlTemplate(AuthCodeDto authCodeDto) { //HTML 템플릿을 렌더링
        return templateEngine.process("emailTemplate",getConText(authCodeDto));
        // 템플릿 엔진을 사용하여 html 템플릿에 데이터 사용 템플릿 파일명, 전달할 데이터
    }

    private Context getConText(AuthCodeDto authCodeDto) {
        Map<String, Object> dto = new HashMap<>(2);
        dto.put("authCode", authCodeDto.getAuthCode()); // 정보저장
        dto.put("maxDate", authCodeDto.getMaxDate());
        Context context = new Context();
        context.setVariables(dto); //이 메서드로 템플릿에서 사용 가능한 변수와 값을 설정
        return context;
    }
}
