package com.example.processfirstproject.mongo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document("hourly-click-stats")
public class ClickHourly {
    @Id
    private String id;
    @Indexed
    String shortUrl;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date from;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date to;
    long clickCount;

    public ClickHourly(String shortUrl,Date from, Date to , long clickCount) {
        this.shortUrl = shortUrl;
        this.from = from;
        this.to = to;
        this.clickCount = clickCount;

    }

    public String getId() {
        return id;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public void setClickCount(long clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public String toString() {
        return "clicked Url stats {'" + " id=" + this.id + ", shortUrl="+ this.shortUrl +", from=" + this.from + ", to=" + this.to + ", click count =" + this.clickCount + '\'' +'}';
    }

}
