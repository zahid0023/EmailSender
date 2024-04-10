package com.example.emailsender.serviceImpl;

import com.example.emailsender.service.EmailSenderService;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.UnsupportedEncodingException;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    private JavaMailSender javaMailSender;

    public EmailSenderServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String content) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom("support@ghuddy.com", "Ghuddy Support");

        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content, true);

        javaMailSender.send(mimeMessage);
    }

    @Override
    public void sendEmailWithAttachment(String to, String subject, String content, File file) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        init(mimeMessage, mimeMessageHelper, to, subject);


        Multipart mimeMultipart = new MimeMultipart();

        MimeBodyPart mimeTextPart = new MimeBodyPart();

        mimeTextPart.setText(content);
        mimeMultipart.addBodyPart(mimeTextPart);
        mimeMessage.set

        MimeBodyPart attachmentPart = new MimeBodyPart();
        attachmentPart.setDataHandler(new DataHandler((DataSource) file));



        javaMailSender.send(mimeMessage);
    }

    private void init(MimeMessage mimeMessage, MimeMessageHelper mimeMessageHelper, String to, String subject) throws MessagingException, UnsupportedEncodingException {


        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom("support@ghuddy.com", "Ghuddy Support");
        mimeMessageHelper.setSubject(subject);

    }

}
