package com.lucas_aiello_studies.email_message_service.service;

import com.lucas_aiello_studies.email_message_service.controller.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImp implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendSimpleEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getContent());
        emailSender.send(message);
    }

    @Override
    public void sendEmailWithAttachment(EmailRequest emailRequest) {}
}
