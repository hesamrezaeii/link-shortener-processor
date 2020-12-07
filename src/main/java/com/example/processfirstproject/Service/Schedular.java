package com.example.processfirstproject.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import com.example.processfirstproject.db.ClickHourlyRepository;
import com.example.processfirstproject.db.UrlClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedular {
    @Autowired private UrlClickRepository urlClickRepository;

    @Autowired ClickHourlyRepository clickHourlyRepository;


//    @Scheduled(fixedRate=30*1000)
    @Scheduled(cron = "0 0 * ? * *")
    public void feignclient() {
        Date now = new Date();
        Date hourAgo = new Date(System.currentTimeMillis() - (1 * 60 * 60 * 1000));
        FeignClientProducer feignClientProducer;
        feignClientimp feignClientimp = new feignClientimp();
        feignClientProducer = feignClientimp.getFeignClientProducer();
        List<ClickHourly> clickHourly = feignClientProducer.getShortUrls().stream().
                map(s -> {
                    List<UrlClick> urlClickObj = urlClickRepository.findByShortUrl(s);
                    List<Date> dates = urlClickObj.stream().map(
                            urlClick -> {
                                if(urlClick.getCreatedDate().after(hourAgo) && urlClick.getCreatedDate().before(now));
                                    return urlClick.getCreatedDate();
                            }
                    ).collect(Collectors.toList());
                    ClickHourly clickHourly1 = new ClickHourly(s,hourAgo,now,dates.size());
                    clickHourlyRepository.save(clickHourly1);
                    return clickHourly1;
                })
                .collect(Collectors.toList());

        System.out.println(clickHourlyRepository.findAll().stream()
                .collect(Collectors.toList()));
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
