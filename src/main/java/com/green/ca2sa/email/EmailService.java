package com.green.ca2sa.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

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
        String template = """
            <!DOCTYPE html>
                           <html>
                           <head>
                               <meta charset="UTF-8">
                               <title>이메일 인증 코드</title>
                               <style>
                                   body {
                                       font-family: Arial, sans-serif;
                                       background-color: #f9f9f9;
                                       margin: 0;
                                       padding: 0;
                                   }
                                   .container {
                                       max-width: 600px;
                                       margin: 0 auto;
                                       background-color: #ffffff;
                                       border: 1px solid #ddd;
                                       border-radius: 8px;
                                       padding: 20px;
                                       box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                                   }
                                   .appName{
                                       text-align: center;
                                       font-size: 50px;
                                       font-weight: bold;
                                       color: #333;
                                   }
                                   .header {
                                       text-align: center;
                                       font-size: 24px;
                                       font-weight: bold;
                                       color: #333;
                                   }
                                   .content {
                                       font-size: 16px;
                                       color: #555;
                                       line-height: 1.6;
                                       margin: 20px 0;
                                   }
                                   .code {
                                       display: block;
                                       font-size: 32px;
                                       font-weight: bold;
                                       color: #007BFF;
                                       text-align: center;
                                       margin: 20px 0;
                                   }
                                   .footer {
                                       font-size: 12px;
                                       color: #aaa;
                                       text-align: center;
                                       margin-top: 20px;
                                   }
                               </style>
                           </head>
                           <body>
                               <div class="container">
                                   <div class="appName">CA2SA</div>
                                   <br/>
                                   <div class="header">이메일 인증 코드</div>
                                   <div class="content">
                                       안녕하세요,<br>
                                       CA2SA 입니다.<br>
                                       요청하신 이메일 인증 코드입니다.<br>
                                       아래의 인증 코드를 입력해주세요:
                                   </div>
                                   <div class="code">%s</div>
                                   <div class="footer">
                                       © 2024 CA2SA. All rights reserved.
                                   </div>
                               </div>
                           </body>
                           </html>
        """;
        return String.format(template, code);
    }
}
