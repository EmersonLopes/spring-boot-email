package com.example.springbootemail.controllers;

import com.example.springbootemail.dtos.EmailDTO;
import com.example.springbootemail.models.EmailModel;
import com.example.springbootemail.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDTO emailDTO){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        EmailModel model = emailService.sendEmail(emailModel);
        return new ResponseEntity<>(model, HttpStatus.CREATED);

    }
}
