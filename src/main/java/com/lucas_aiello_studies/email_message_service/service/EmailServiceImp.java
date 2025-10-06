package com.lucas_aiello_studies.email_message_service.service;

import com.lucas_aiello_studies.email_message_service.controller.dto.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImp implements EmailService {

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendSimpleEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getContent());
        sender.send(message);
    }

    @Override
    public void sendEmailWithAttachment(EmailRequest emailRequest) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(emailRequest.getTo());
        helper.setSubject(emailRequest.getSubject());
        helper.setText(emailRequest.getContent());

        FileSystemResource file
                = new FileSystemResource(new File(emailRequest.getAttachment()));
        helper.addAttachment("Request File", file);

        sender.send(message);
    }
}
