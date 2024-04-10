package com.example.emailsender.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EmailRequest {
    private String recipient;
    private String subject;
    private String body;
    private MultipartFile multipartFile;

    // Default constructor
    public EmailRequest() {
    }

}
