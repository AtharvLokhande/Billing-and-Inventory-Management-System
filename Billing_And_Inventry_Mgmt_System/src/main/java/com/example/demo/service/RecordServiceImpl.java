package com.example.demo.service;

import com.example.demo.model.Record;
import com.example.demo.service.RecordService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RecordServiceImpl implements RecordService {

    private final AtomicInteger recordIdCounter = new AtomicInteger(1); // Simulated ID generation

    @Override
    public Record createRecord(Record record) {
        record.setRecordId(recordIdCounter.getAndIncrement());
        record.setRecordedAt(Timestamp.from(Instant.now()));
        return record;
    }
}
