package com.izanaar.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(urlPatterns = {"/send_mail"},
        name = "MailServlet",
        initParams = {
                @WebInitParam(name = "com.spittr.config-path", value = "/com.spittr.config/mail.properties")
        })
public class MailServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String host, port, username, password;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();

        String path = getInitParameter("com.spittr.config-path");

        try {
            properties.load(getServletContext().getResourceAsStream(path));
            host = properties.getProperty("mail.smtp.host");
            port = properties.getProperty("mail.smtp.port");
            username = properties.getProperty("mail.user.name");
            password = properties.getProperty("mail.user.password");

            logger.trace("Mail properties have been initialized.");

        } catch (Exception e) {
            logger.error("Couldn't load properties. Exception: {}", e.toString());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sender", username);
        req.getRequestDispatcher("/WEB-INF/pages/mailSending.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String to = req.getParameter("to"),
                subject = req.getParameter("subject"),
                text = req.getParameter("text");

        logger.info("to: {}", to);
        logger.info("subj: {}", subject);
        logger.info("text: {}", text);

        req.setAttribute("recipient", req.getParameter("to"));

        req.getRequestDispatcher("/WEB-INF/pages/mailSent.jsp").forward(req,resp);

        try {
            sendEmail(to, subject, text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void sendEmail(String to, String subj, String text) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(username));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("izanaar@gmail.com"));

            // Set Subject: header field
            message.setSubject("Testing Subject");

            // Now set the actual message
            message.setText("Hello, this is sample for to check send " +
                    "email using JavaMailAPI ");

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");


    }
}
