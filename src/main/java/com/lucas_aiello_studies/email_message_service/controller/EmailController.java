package com.lucas_aiello_studies.email_message_service.controller;

import com.lucas_aiello_studies.email_message_service.controller.dto.EmailRequest;
import com.lucas_aiello_studies.email_message_service.controller.dto.EmailResponse;
import com.lucas_aiello_studies.email_message_service.service.EmailServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailServiceImp emailService;

    @PostMapping
    private ResponseEntity<EmailResponse> sendEmail(@Valid @RequestBody EmailRequest emailRequest) {
        emailService.sendSimpleEmail(emailRequest);
        return ResponseEntity.ok(new EmailResponse(emailRequest.getTo()));
    }

}
