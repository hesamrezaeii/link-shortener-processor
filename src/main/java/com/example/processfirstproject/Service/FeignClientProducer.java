package com.example.processfirstproject.Service;

import feign.RequestLine;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
public interface FeignClientProducer {
    @RequestLine("GET")
    public List<String> getShortUrls();

}

