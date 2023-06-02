package com.email.mailconfig;

import com.email.utils.PasswordPicker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {

    PasswordPicker passwordPicker = new PasswordPicker();
    String getPasswordValue = passwordPicker.readFile();
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.username}")
    private String username;

//    @Value("${getPasswordValue}")
//    private String password;

    @Value("${spring.mail.mail-props}")
    private String mailprops;
    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(Integer.parseInt(port));
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(getPasswordValue);

        Properties props = javaMailSender.getJavaMailProperties();
        props.put(mailprops, "true");
        return javaMailSender;
    }

}
