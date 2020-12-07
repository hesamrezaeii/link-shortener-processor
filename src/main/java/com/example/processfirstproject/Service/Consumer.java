package com.example.processfirstproject.Service;


import com.example.processfirstproject.db.UrlClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@EnableKafka
public class Consumer {

    @Autowired
    UrlClickRepository urlClickRepository;

    @KafkaListener(topics = "urlstats", groupId = "group_id")
    public void consumeClick(String shortUrl) {
        UrlClick urlClick = new UrlClick( shortUrl, new Date());
        urlClickRepository.insert(urlClick);
    }
}
