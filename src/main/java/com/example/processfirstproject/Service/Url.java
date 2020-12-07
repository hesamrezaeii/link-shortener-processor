package com.example.processfirstproject.Service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Url")
public class Url {
    @Id
    private String id;
    @Indexed
    String originalUrl;
    private String shortUrl;
    private String ip;
    public Url(String originalUrl, String shortUrl , String ip) {
        this.ip = ip;
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Url(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Url() {
    }

    public String getId() {
        return id;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    @Override
    public String toString() {
        return "URL{" + "id=" + this.id + ", originalUrl=" + this.originalUrl + '\'' + ", shortUrl='" + this.shortUrl + '\'' + '}';
    }
}