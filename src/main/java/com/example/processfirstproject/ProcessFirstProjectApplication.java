package com.example.processfirstproject;

import com.example.processfirstproject.db.UrlClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@RestController
public class ProcessFirstProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessFirstProjectApplication.class, args);
    }

}
