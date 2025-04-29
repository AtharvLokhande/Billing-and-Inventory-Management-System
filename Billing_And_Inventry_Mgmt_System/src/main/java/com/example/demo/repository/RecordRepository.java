package com.example.demo.repository;

import com.example.demo.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecordRepository implements RecordRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Record save(Record record) {
        String sql = "INSERT INTO records (user_id, order_id, payment_id, name, address, contact, email, organization, " +
                     "designation, order_type, amount_paid) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                record.getUserId(),
                record.getOrderId(),
                record.getPaymentId(),
                record.getName(),
                record.getAddress(),
                record.getContact(),
                record.getEmail(),
                record.getOrganization(),
                record.getDesignation(),
                record.getOrderType().name(),
                record.getAmountPaid()
        );

        // Optionally: retrieve the last inserted ID if your DB supports it.
        return record;
    }

    @Override
    public List<Record> findAll() {
        String sql = "SELECT * FROM records";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Record.class));
    }

    @Override
    public Optional<Record> findById(Integer recordId) {
        String sql = "SELECT * FROM records WHERE record_id = ?";
        try {
            Record record = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Record.class), recordId);
            return Optional.ofNullable(record);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
