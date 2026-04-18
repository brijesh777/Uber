package com.uber.uberApp;

import com.uber.uberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {


    @Autowired
    private EmailSenderService emailSenderService;


//    @Test
//    void contextLoads() {
//
//        emailSenderService.sendEmail("jaxoro5235@iotrama.com", "This is the Testing Email", "Body of my mail");
//    }

    @Test
    void sendEmailMultiple(){
        String emails[] = {
                "jaxoro5235@iotrama.com",
                "makwanabrijesh7879@gmail.com"
        };

        emailSenderService.sendEmail(emails, "This is the Subject Email", "Body of my mail");
    }

}
