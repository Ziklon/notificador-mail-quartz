/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Wilber
 */
public class AppMail {

   
    private static Logger log = LoggerFactory.getLogger(AppMail.class.getName());
    
    public void sendMail() {

        PropertiesInterno.load();

        log.info("Iniciando envio de correo ");
        
        final String username = PropertiesInterno.CORREO_USERNAME;
        final String password = PropertiesInterno.CORREO_PASSWORD;

        Properties props = new Properties();

        props.put("mail.smtp.auth", PropertiesInterno.MAIL_SMTP_AUTH);
        props.put("mail.smtp.starttls.enable", PropertiesInterno.MAIL_SMTP_STARTTLS_ENABLE);
        props.put("mail.smtp.host", PropertiesInterno.MAIL_SMTP_HOST);
        props.put("mail.smtp.port", PropertiesInterno.MAIL_SMTP_PORT);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);

            
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("HH:mm:ss");
            
            
            message.setFrom(new InternetAddress(PropertiesInterno.CORREO_FROM_USERNAME));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(PropertiesInterno.CORREO_TO_USERNAME));
            message.setSubject("Testing Subject " +simpleDateFormat.format(new Date()));
            String text = "Dear Mail Crawler,"
                    + "\n\n No spam to my email, Hello World Message please!";

            message.setText(text, "utf-8", "html");

            Transport.send(message);
            
            log.info("Envio de correo exitoso de "+PropertiesInterno.CORREO_FROM_USERNAME + 
                    " a " +PropertiesInterno.CORREO_TO_USERNAME);

        } catch (MessagingException e) {
            log.error("Envio de correo fallido ");
            throw new RuntimeException(e);            
        }
    }

}
