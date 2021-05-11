package com.example.springmailsender;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.mail.*;

@RestController
@Component
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController( EmailSenderService emailSenderService ) {
        this.emailSenderService = emailSenderService;
    }

    @RequestMapping(value = "/sendEmail")
    public String sendEmail() throws MessagingException {

        emailSenderService.sendMail("amimulahsan7@gmail.com");

//        String backPart = "@ugrad.cse.buet.ac.bd";
//
//        int front = 1805000;
//
//        for(int i=1; i<=120; i++)
//        {
//            front += 1;
//            emailSenderService.sendMail(front + backPart);
//        }

        return "Email sent successfully";
    }

}
