package com.example.processfirstproject.db;


import com.example.processfirstproject.Service.ClickHourly;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ClickHourlyRepository extends MongoRepository<ClickHourly,String>{
    ClickHourly findByFromAndTo(Date from , Date to);
}

