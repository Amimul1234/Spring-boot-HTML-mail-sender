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

        message.setContent("Eid Mubarak! May Allah fulfill all your dreams and hopes.\n" +
                "\n" +
                "May the blessings of Allah be with you and your family forever and always. Eid Mubarak!\n" +
                "\n" +
                "May Allah bless your life and fulfill all your wishes and Dua’s. Eid Mubarak.", "text/html");

        message.setSentDate(new Date());
        Transport.send(message);
    }
}
