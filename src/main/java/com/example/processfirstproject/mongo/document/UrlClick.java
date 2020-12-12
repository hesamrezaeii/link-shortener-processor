package com.example.processfirstproject.mongo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document("Url-click-stats")
public class UrlClick {
    @Id
    private String id;
    @Indexed
    private String shortUrl;
    @Indexed
    private String originalUrl;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) private Date date;
    private String ip;
    private String userAgent;

    public String getId() {
        return id;
    }

    public UrlClick(String shortUrl, String originalUrl, Date date, String ip, String userAgent) {
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
        this.date = date;
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "UrlClick{" +
                "id='" + id + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", originalUrl='" + originalUrl + '\'' +
                ", date=" + date +
                ", ip='" + ip + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
