package com.curatedcrates.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String from, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("shreyaabest15@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        message.setFrom(from);
        mailSender.send(message);
    }
}
