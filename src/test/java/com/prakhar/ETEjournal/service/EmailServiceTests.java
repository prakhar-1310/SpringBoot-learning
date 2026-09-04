package com.prakhar.ETEjournal.service;

import com.prakhar.ETEjournal.Service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    @Disabled
    public void testSendEmail() {
        emailService.sendEmail("prakharshahi9935@gmail.com", "Testing", "How are you?");
    }
}
