package com.example.processfirstproject.Control;

import com.example.processfirstproject.Service.ClickHourly;
import com.example.processfirstproject.Service.UrlClick;
import com.example.processfirstproject.db.ClickHourlyRepository;
import com.example.processfirstproject.db.UrlClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    @Autowired
    ClickHourlyRepository clickHourlyRepository;
    @Autowired
    UrlClickRepository urlClickRepository;
    @GetMapping("/all-click-hourly")
    List<ClickHourly> allClickHourly() {

        List<ClickHourly> clkhrl = clickHourlyRepository.findAll().stream()
                .collect(Collectors.toList());
        return clkhrl;
    }
    @GetMapping("/all-url-clicks")
    List<UrlClick> allUrlHourly() {

        List<UrlClick> urlclk = urlClickRepository.findAll().stream()
                .collect(Collectors.toList());
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
