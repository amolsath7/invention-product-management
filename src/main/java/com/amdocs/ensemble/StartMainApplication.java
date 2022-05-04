package com.amdocs.ensemble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableRetry
public class StartMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartMainApplication.class, args);
    }

}
