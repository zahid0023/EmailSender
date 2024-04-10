package com.example.emailsender.controller;

import com.example.emailsender.dto.EmailRequest;
import com.example.emailsender.service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class EmailController {

    private final EmailSenderService emailSenderService;


    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send/email/without/attachment")
    public ResponseEntity<String> sendEmailWithOutAttachment(@RequestBody EmailRequest emailRequest) throws MessagingException, UnsupportedEncodingException {

        emailSenderService.sendEmail(emailRequest.getRecipient(), emailRequest.getSubject(), emailRequest.getBody());
        return ResponseEntity.ok("Email sent successfully");

    }
}
