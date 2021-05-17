package com.velheor.internship.email;

import com.velheor.internship.dto.UserViewDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailSender {

    private final SpringTemplateEngine thymeleafTemplateEngine;

    private final JavaMailSender mailSender;

    @SneakyThrows
    private void sendHtmlMessage(String to, String subject, String htmlBody) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        mailSender.send(message);
    }

    public void sendMessageAfterSignUp(UserViewDTO userViewDTO, String token) {
        Context thymeleafContext = new Context();
        Map<String, Object> variables = new HashMap<>();
        variables.put("token", token);
        variables.put("user", userViewDTO);
        thymeleafContext.setVariables(variables);
        String htmlBody = thymeleafTemplateEngine.process("registrationMessage.html", thymeleafContext);

        sendHtmlMessage(userViewDTO.getEmail(), "Activation code", htmlBody);
    }
}
