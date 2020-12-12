package com.example.processfirstproject.mongo.repo;

import com.example.processfirstproject.mongo.document.UrlClick;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UrlClickRepository extends MongoRepository<UrlClick,String> {
    List<UrlClick> findByShortUrl(String shortUrl);
    List<UrlClick> findByDateBetween(@Param("from") Date from, @Param("to") Date to);

    List<UrlClick> findByShortUrlAndDateBetween(String s, Date hourAgo, Date now);
//    List<UrlClick> findByShortUrlAndDateBetween(String shortUrl,@Param("from") Date from, @Param("to") Date to);

}
