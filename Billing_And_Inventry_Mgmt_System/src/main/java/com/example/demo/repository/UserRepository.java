package com.example.demo.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;
import com.example.demo.model.Record;

@Repository
public class UserRepository implements UserRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUserAndProfile(String username, String password, String userRoll,
                                   String name, String address, String contact,
                                   String email, String organization, String designation) {
        String sql = "{CALL createUserProfile(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, username, password, userRoll, name, address, contact, email, organization, designation);
    }

    @Override
    public String findUserRoleByUsernameAndPassword(String username, String password) {
        String sql = "SELECT user_roll FROM users WHERE username = ? AND password = ?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, username, password);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        String sql = "SELECT p.user_id, u.username, p.name, p.address, p.contact, p.email, p.organization, u.user_roll " +
                    "FROM profiles p JOIN users u ON p.user_id = u.user_id " +
                    "WHERE u.user_roll != 'Customer'";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
            new EmployeeResponse(
                rs.getInt("user_id"),
                rs.getString("username"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("contact"),
                rs.getString("email"),
                rs.getString("organization"),
                rs.getString("user_roll")
            )
        );
    }

    @Override
    public boolean deleteEmployeeById(int userId) {
        // First delete profile to maintain referential integrity
        String deleteProfileSql = "DELETE FROM profiles WHERE user_id = ?";
        jdbcTemplate.update(deleteProfileSql, userId);
        
        String deleteUserSql = "DELETE FROM users WHERE user_id = ?";
        int rowsAffected = jdbcTemplate.update(deleteUserSql, userId);
        return rowsAffected > 0;
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT product_id, name, supplier_id, quantity, price, gst_percentage, description, brand, category " +
                    "FROM products";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public Record save(Record record) {
        String sql = "INSERT INTO records (user_id, order_id, payment_id, name, address, contact, email, organization, " +
                     "designation, order_type, amount_paid) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            record.getOrderType().name(), // Assuming enum
            record.getAmountPaid()
//            record.getRecordedAt()
        );

        return record; // You can optionally return with an auto-generated ID if needed
    }


}