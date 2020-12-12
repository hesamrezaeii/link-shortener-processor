package com.example.processfirstproject.mongo.repo;


import com.example.processfirstproject.mongo.document.ClickHourly;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface ClickHourlyRepository extends MongoRepository<ClickHourly,String>{
    List<ClickHourly> findByFromAndTo(Date from , Date to);
}

