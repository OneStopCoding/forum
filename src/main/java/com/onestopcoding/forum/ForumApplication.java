package com.onestopcoding.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@ConfigurationPropertiesScan
public class ForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }

}
