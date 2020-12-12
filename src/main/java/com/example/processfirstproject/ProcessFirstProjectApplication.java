package com.example.processfirstproject;

import com.example.processfirstproject.feign.GatewayFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackageClasses = GatewayFeignClient.class)
public class ProcessFirstProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessFirstProjectApplication.class, args);
    }

}
