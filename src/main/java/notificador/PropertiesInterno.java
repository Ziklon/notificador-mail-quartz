/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificador;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wilber
 */
public class PropertiesInterno {

    public static String CORREO_USERNAME = "correo.username";
    public static String CORREO_PASSWORD = "correo.password";

    public static String MAIL_SMTP_AUTH = "mail.smtp.auth";
    public static String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    public static String MAIL_SMTP_HOST = "mail.smtp.host";
    public static String MAIL_SMTP_PORT = "mail.smtp.port";

    public static String CORREO_FROM_USERNAME = "correo.from.username";
    public static String CORREO_TO_USERNAME = "correo.to.username";

    private static boolean loaded = false;

    public static void load() {
        if (loaded == false) {
            Properties properties = new Properties();
            try {
                InputStream input = PropertiesInterno.class.getClassLoader().getResourceAsStream("/config.properties");
                properties.load(input);
                CORREO_USERNAME = properties.getProperty(CORREO_USERNAME);
                CORREO_PASSWORD = properties.getProperty(CORREO_PASSWORD);
                MAIL_SMTP_AUTH = properties.getProperty(MAIL_SMTP_AUTH);

                MAIL_SMTP_STARTTLS_ENABLE = properties.getProperty(MAIL_SMTP_STARTTLS_ENABLE);

                MAIL_SMTP_HOST = properties.getProperty(MAIL_SMTP_HOST);

                MAIL_SMTP_PORT = properties.getProperty(MAIL_SMTP_PORT);

                CORREO_FROM_USERNAME = properties.getProperty(CORREO_FROM_USERNAME);
                CORREO_TO_USERNAME = properties.getProperty(CORREO_TO_USERNAME);

                loaded = true;
            } catch (IOException ex) {
                Logger.getLogger(PropertiesInterno.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
