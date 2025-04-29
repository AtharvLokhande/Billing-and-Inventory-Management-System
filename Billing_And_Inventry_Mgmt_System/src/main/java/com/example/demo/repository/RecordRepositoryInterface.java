package com.example.demo.repository;

import com.example.demo.model.Record;

import java.util.List;
import java.util.Optional;

public interface RecordRepositoryInterface {
    Record save(Record record);
    List<Record> findAll();
    Optional<Record> findById(Integer recordId);
}
