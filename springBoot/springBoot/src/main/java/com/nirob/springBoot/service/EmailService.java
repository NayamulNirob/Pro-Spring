package com.nirob.springBoot.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Getter
@Setter
@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    public void sendSimpleMail(String to, String subject, String text) throws MessagingException {
        MimeMessage mes = javaMailSender.createMimeMessage();
        MimeMessageHelper massage= new MimeMessageHelper(mes,true);
        massage.setTo(to);
        massage.setSubject(subject);
        massage.setText(text);
        massage.setFrom("nirob@gmail.com");
        javaMailSender.send(mes);
    }
}
