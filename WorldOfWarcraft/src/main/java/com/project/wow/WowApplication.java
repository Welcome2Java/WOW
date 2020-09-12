package com.project.wow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class WowApplication {

    public static void main(String[] args) {
        SpringApplication.run(WowApplication.class, args);
    }

}
