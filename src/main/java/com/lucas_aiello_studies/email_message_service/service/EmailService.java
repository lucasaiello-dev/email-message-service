package com.lucas_aiello_studies.email_message_service.service;

import com.lucas_aiello_studies.email_message_service.controller.dto.EmailRequest;

import java.util.Properties;

public interface EmailService {
    void sendSimpleEmail(EmailRequest emailRequest);
    void sendEmailWithAttachment(EmailRequest emailRequest);
}
