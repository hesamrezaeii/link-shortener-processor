package com.example.processfirstproject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name ="feign-service",url = "http://localhost:8080")
public interface GatewayFeignClient {
    @RequestMapping(method = RequestMethod.GET, path = "/api/ten-short-urls")
    List<String> getShortUrls();
}
