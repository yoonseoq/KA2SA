package com.green.ca2sa.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Slf4j
@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public boolean sendCodeToEmail(String to, String subject, String code) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(getHtmlTemplate(code), true);
            javaMailSender.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    private String getHtmlTemplate(String code) {
        Context context = new Context();
        String template = templateEngine.process("emailTemplate", context);
        return template.replace("${code}", code);
    }
}
