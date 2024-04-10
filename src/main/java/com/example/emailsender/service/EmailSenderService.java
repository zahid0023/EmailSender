package com.example.emailsender.service;

import jakarta.mail.MessagingException;

import java.io.File;
import java.io.UnsupportedEncodingException;

public interface EmailSenderService {
    public void sendEmail(String to, String subject, String content) throws MessagingException, UnsupportedEncodingException;
    public void sendEmailWithAttachment(String to, String subject, String content, File file);
}
