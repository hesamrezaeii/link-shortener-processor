package com.example.processfirstproject.Service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Document("Url-click-stats")
public class UrlClick {
    @Id
    private String id;
    @Indexed
    private String originalUrl;
    private String shortUrl;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UrlClick() {
    }

    public UrlClick(String originalUrl, String shortUrl,Date createdDate) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.createdDate = createdDate;

    }


//
//    public UrlClick(String originalUrl, String shortUrl, long clickCount) {
//        this.originalUrl = originalUrl;
//        this.shortUrl = shortUrl;
//    }

    public String getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    
    @Override
    public String toString() {
        return "URL{" + "id=" + this.id + ", originalUrl=" + this.originalUrl + '\'' + ", shortUrl='" + this.shortUrl + '\'' + ", date='" + this.createdDate + '\'' + '}';
    }

}
