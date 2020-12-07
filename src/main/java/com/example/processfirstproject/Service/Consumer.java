package com.example.processfirstproject.Service;


import com.example.processfirstproject.db.UrlClickRepository;
import com.example.processfirstproject.db.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@EnableKafka
public class Consumer {

    @Autowired
    UrlClickRepository urlClickRepository;
    @Autowired
    private UrlRepository urlRepository;

    @KafkaListener(topics = "urlstats", groupId = "group_id")
    public void consumeClick(String url) {
        Url exist = urlRepository.findByShortUrl(url);
        if (exist != null) {
            UrlClick urlClick = new UrlClick(exist.getOriginalUrl(), exist.getShortUrl(), new Date());
            urlClickRepository.insert(urlClick);
            System.out.println(urlClick);
        }
    }
}
