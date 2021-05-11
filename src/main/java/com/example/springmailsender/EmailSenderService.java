package com.example.springmailsender;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailSenderService {

    @Async
    void sendMail(String emailAddress) throws MessagingException
    {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rider124225@gmail.com", "ForLife124225");
            }
        });


        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("rider124225@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress));
        message.setSubject("Eid er salami");

        message.setContent("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <h1>Dear Fellow Brothers and sisters:</h1>\n" +
                "  <img style=\"max-width: 100%; height: auto\"\n" +
                "       src=\"https://drive.google.com/uc?id=1v2E9mqocmRCgNEfIUoG6w7uUjLfrJCot\" alt=\"Salami\">\n" +
                "</body>\n" +
                "</html>", "text/html");

        message.setSentDate(new Date());
        Transport.send(message);
    }
}
