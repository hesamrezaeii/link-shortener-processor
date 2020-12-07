package com.example.processfirstproject.db;

import com.example.processfirstproject.Service.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UrlRepository extends MongoRepository<Url,String> {
    Url findByShortUrl(String shortUrl);
    Url findByOriginalUrl(String originalUrl);
}

