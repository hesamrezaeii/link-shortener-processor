package com.example.processfirstproject.Controller;

import com.example.processfirstproject.mongo.document.ClickHourly;
import com.example.processfirstproject.mongo.document.UrlClick;
import com.example.processfirstproject.mongo.repo.ClickHourlyRepository;
import com.example.processfirstproject.mongo.repo.UrlClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicController {
    @Autowired
    private ClickHourlyRepository clickHourlyRepository;

    @Autowired
    private UrlClickRepository urlClickRepository;

    @GetMapping("/all-click-hourly")
    private List<ClickHourly> allClickHourly() {

        List<ClickHourly> clkhrl = clickHourlyRepository.findAll();
        return clkhrl;
    }
    @GetMapping("/all-url-clicks")
    List<UrlClick> allUrlClick() {

        List<UrlClick> urlclk = urlClickRepository.findAll();
        return urlclk;
    }

    @DeleteMapping("/all-url-clicks")
    String deleteAllUrlClicks() {
        urlClickRepository.deleteAll();
        return "cleared";
    }
    @DeleteMapping("/all-click-hourly")
    String deleteAllClickHourly() {
        clickHourlyRepository.deleteAll();
        return "cleared";
    }
}
