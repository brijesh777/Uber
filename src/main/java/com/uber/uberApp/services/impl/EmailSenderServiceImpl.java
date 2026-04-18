package com.uber.uberApp.services.impl;

import com.uber.uberApp.services.EmailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setText(body);
            simpleMailMessage.setTo(toEmail);
            simpleMailMessage.setSubject(body);
            javaMailSender.send(simpleMailMessage);
            log.info("Email sent successfully");


        } catch (Exception e) {
            log.info("Cannot send emai " + e.getMessage());
        }
    }

    @Override
    public void sendEmail(String[] toEmail, String subject, String body) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setTo(toEmail);       // Use the 'toEmail' parameter for the recipient
            simpleMailMessage.setSubject(subject);  // Use the 'subject' parameter for the subject
            simpleMailMessage.setText(body);        // This was already correct

            javaMailSender.send(simpleMailMessage);

            // Improved logging
            log.info("Email sent successfully to: {}", String.join(", ", toEmail));

        } catch (Exception e) {
            // Use log.error to include the full stack trace for better debugging
            log.error("Failed to send email", e);
        }
    }
}
