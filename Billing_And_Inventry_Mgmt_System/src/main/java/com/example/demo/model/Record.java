package com.example.demo.model;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Record {
    private Integer recordId;
    private Integer userId;
    private Integer orderId;
    private Integer paymentId;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String organization;
    private String designation;
    private OrderType orderType;
    private Double amountPaid;
    private Timestamp recordedAt;
}
