package com.base;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;

public class EmailReport {

    public void emailReportGenerator() throws InterruptedException {
        System.out.println("Email started");

        // Set up the mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Port for STARTTLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Get the Session object
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("lvtstng@gmail.com", "woqj vthn eqkm uglt"); // Your Gmail credentials
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("lvtstng@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("lvtstng@gmail.com")); // Recipient email
            message.setSubject("KAFD Automation Test Report");

            // Create the body parts
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("Overall Selenium Test Report");

            BodyPart messageBodyPart2 = new MimeBodyPart();
            messageBodyPart2.setText("Error ....");

            BodyPart attachmentPart = new MimeBodyPart();
            String filePath = System.getProperty("user.dir") + "./report/index.html";
            DataSource source = new FileDataSource(filePath);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName("index.html");

            // Create a multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);
            multipart.addBodyPart(attachmentPart);

            // Set the content of the message
            message.setContent(multipart);

            // Send the email
            Transport.send(message);
            System.out.println("MAIL TRIGGERED");

        } catch (MessagingException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            throw new RuntimeException(e);
        }
    }
}
