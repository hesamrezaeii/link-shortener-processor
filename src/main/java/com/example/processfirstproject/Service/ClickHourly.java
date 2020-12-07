package com.example.processfirstproject.Service;

import com.example.processfirstproject.Service.UrlClick;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Document("hourly-click-stats")
public class ClickHourly {
    @Id
    private String id;
    @Indexed
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date from;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date to;
    List<UrlClick> urlClicks;

    public ClickHourly(Date from, Date to, List<UrlClick> urlClicks) {
        this.from = from;
        this.to = to;
        this.urlClicks = urlClicks;
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

    public List<UrlClick> getUrlClicks() {
        return urlClicks;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public void setUrlClicks(List<UrlClick> urlClicks) {
        this.urlClicks = urlClicks;
    }

    @Override
    public String toString() {
        return "clicked Url stats {" + "id=" + this.id + ", from=" + this.from + '\'' + " to='" + this.to + '\'' + ", urls='" + this.urlClicks + '\'' + '}';
    }

}
