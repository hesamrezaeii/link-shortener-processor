package com.example.processfirstproject.db;

import com.example.processfirstproject.Service.UrlClick;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface UrlClickRepository extends MongoRepository<UrlClick,String> {
    List<UrlClick> findByShortUrl(String shortUrl);
    List<UrlClick> findByCreatedDateBetween(@Param("from") Date from, @Param("to") Date to);

}
