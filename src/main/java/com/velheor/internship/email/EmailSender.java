package com.velheor.internship.email;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailSender {

    private final SpringTemplateEngine thymeleafTemplateEngine;

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

    private void sendHtmlMessage(String to, String subject, String htmlBody) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }

    public void sendMessageUsingThymeleafTemplate(
            String to, String subject, Map<String, Object> templateModel) {

        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);
        String htmlBody = thymeleafTemplateEngine.process("registrationMessage.html", thymeleafContext);

        sendHtmlMessage(to, subject, htmlBody);
    }
}
