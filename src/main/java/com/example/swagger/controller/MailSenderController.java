package com.example.swagger.controller;
import com.example.swagger.servise.MailSenderService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailSenderController {
    private final MailSenderService mailSenderService;
    @PostMapping("/simple")
    public String sendSimpleEmail(@RequestParam String username) throws MessagingException {
        mailSenderService.sendSimpleEmail(username);
        return "Send Massage";
    }
}
