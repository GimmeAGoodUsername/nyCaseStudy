package com.ny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
public class NewYorkerCaseApp {

    public static void main(String[] args) {
        SpringApplication.run(NewYorkerCaseApp.class, args);
    }
}
