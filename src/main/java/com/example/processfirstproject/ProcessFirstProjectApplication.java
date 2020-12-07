package com.example.processfirstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProcessFirstProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessFirstProjectApplication.class, args);

    }

}
