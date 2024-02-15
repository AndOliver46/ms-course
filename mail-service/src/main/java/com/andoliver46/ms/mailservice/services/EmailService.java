package com.andoliver46.ms.mailservice.services;

import com.andoliver46.ms.mailservice.enums.EmailStatus;
import com.andoliver46.ms.mailservice.models.EmailModel;
import com.andoliver46.ms.mailservice.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String emailFrom;

    private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;

    public EmailService(EmailRepository emailRepository, JavaMailSender mailSender) {
        this.emailRepository = emailRepository;
        this.mailSender = mailSender;
    }

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel){
        try{
            emailModel.setSendDateEmail(LocalDateTime.now());
            emailModel.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());

            mailSender.send(message);

            emailModel.setEmailStatus(EmailStatus.SENT);
        }catch(Exception e){
            emailModel.setEmailStatus(EmailStatus.ERROR);
        }finally {
            emailRepository.save(emailModel);
        }

        return emailModel;
    }
}
