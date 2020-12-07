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

    public UrlClick(String shortUrl,Date createdDate) {
        this.shortUrl = shortUrl;
        this.createdDate = createdDate;

    }

    public String getId() {
        return id;
    }


    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    
    @Override
    public String toString() {
        return "URL{" + "id=" + this.id + '\'' + ", shortUrl='" + this.shortUrl + '\'' + ", date='" + this.createdDate + '\'' + '}';
    }

}
