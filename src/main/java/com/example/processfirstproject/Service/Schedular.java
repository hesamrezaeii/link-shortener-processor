package com.example.processfirstproject.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.example.processfirstproject.db.ClickHourlyRepository;
import com.example.processfirstproject.db.UrlClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedular {
    @Autowired private UrlClickRepository urlClickRepository;
    @Autowired
    ClickHourlyRepository clickHourlyRepository;

    //@Scheduled(fixedRate=1*60*1000)
    @Scheduled(cron = "0 0 * ? * *")
    public void fixedRateSch() {
        Date now = new Date();
        Date hourAgo = new Date(System.currentTimeMillis() - (1 * 60 * 60 * 1000));


        List<UrlClick> urls = urlClickRepository.findByCreatedDateBetween(hourAgo,now);
        ClickHourly clickHourly = new ClickHourly(hourAgo,now,urls);
        clickHourlyRepository.save(clickHourly);
        urlClickRepository.deleteAll();
    }
}
