package com.example.swagger.servise;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {
    private  final JavaMailSender javaMailSender;
    @Async
    public void sendSimpleEmail(String username) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.setFrom("from@gmail.com");
        mimeMessage.setRecipients(Message.RecipientType.TO,"to@gmail.com");
        mimeMessage.setSubject("Subject from oops");
        mimeMessage.setText("Hello  Bekzod's blog followers");
        javaMailSender.send(mimeMessage);

    }
}
