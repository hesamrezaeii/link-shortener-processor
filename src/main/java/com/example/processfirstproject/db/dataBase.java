package com.example.processfirstproject.db;

import com.example.processfirstproject.Service.ClickHourly;
import com.example.processfirstproject.db.UrlClickRepository;
import com.example.processfirstproject.db.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class dataBase implements CommandLineRunner {
    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private UrlClickRepository urlClickRepository;
    @Autowired
    ClickHourlyRepository clickHourlyRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(urlClickRepository.findAll());
    }
}