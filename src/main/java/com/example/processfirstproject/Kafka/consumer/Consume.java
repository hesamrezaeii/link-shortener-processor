package com.example.processfirstproject.Kafka.consumer;


import com.example.processfirstproject.Kafka.messageType.UrlClickMessage;
import com.example.processfirstproject.mongo.document.UrlClick;
import com.example.processfirstproject.mongo.repo.UrlClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consume {
    private static final String TOPIC = "urlstats";
    @Autowired
    UrlClickRepository urlClickRaepository;

    @KafkaListener(topics = "urlClick", containerFactory = "kafkaListenerContainerFactory")
    public void consume(UrlClickMessage urlClickMessage) {
        UrlClick urlClick = new UrlClick(urlClickMessage.getShortUrl(),urlClickMessage.getOriginalUrl(),urlClickMessage.getDate(),urlClickMessage.getIp(),urlClickMessage.getUserAgent());
        System.out.println(urlClickRaepository.insert(urlClick));

    }

}
