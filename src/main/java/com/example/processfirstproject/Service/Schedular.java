package com.example.processfirstproject.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import com.example.processfirstproject.feign.GatewayFeignClient;
import com.example.processfirstproject.mongo.document.ClickHourly;
import com.example.processfirstproject.mongo.document.UrlClick;
import com.example.processfirstproject.mongo.repo.ClickHourlyRepository;
import com.example.processfirstproject.mongo.repo.UrlClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedular {
    @Autowired
    private UrlClickRepository urlClickRepository;

    @Autowired
    private ClickHourlyRepository clickHourlyRepository;

    @Autowired
    private GatewayFeignClient gatewayFeignClient;


    @Scheduled(fixedRate = 30 * 1000)
//    @Scheduled(cron = "0 0 * ? * *")
    public void feignclient() {
        Date now = new Date();
        Date hourAgo = new Date(System.currentTimeMillis() - (60 * 60 * 1000));

//        gatewayFeignClient.getShortUrls().stream().
//                map(s -> {
//                    List<UrlClick> urlClickObj = urlClickRepository.findByShortUrl(s);
//                    List<Date> dates = urlClickObj.stream().filter(urlClick -> urlClick.getDate().after(hourAgo) && urlClick.getDate().before(now)).map(UrlClick::getDate).collect(Collectors.toList());
//                    ClickHourly clickHourly1 = new ClickHourly(s, hourAgo, now, dates.size());
//                    clickHourlyRepository.save(clickHourly1);
//                    return clickHourly1;
//                })
//                .collect(Collectors.toList());
        gatewayFeignClient.getShortUrls().stream().
                map(s -> {
                    List<UrlClick> urlClickObj = urlClickRepository.findByShortUrlAndDateBetween(s,hourAgo,now);
                    ClickHourly clickHourly1 = new ClickHourly(s, hourAgo, now, urlClickObj.size());
                    clickHourlyRepository.save(clickHourly1);
                    return clickHourly1;
                }).collect(Collectors.toList());
        System.out.println(clickHourlyRepository.findAll());
        System.out.println(clickHourlyRepository.findByFromAndTo(hourAgo, now));
    }
    //@Scheduled(fixedRate=1*60*1000)
//    @Scheduled(cron = "0 0 * ? * *")
//    public void fixedRateSch() {
//        Date now = new Date();
//        Date hourAgo = new Date(System.currentTimeMillis() - (1 * 60 * 60 * 1000));
//
//
//        List<UrlClick> urls = urlClickRepository.findByCreatedDateBetween(hourAgo,now);
//        ClickHourly clickHourly = new ClickHourly(hourAgo,now,urls);
//        clickHourlyRepository.save(clickHourly);
//        urlClickRepository.deleteAll();
//    }
}
