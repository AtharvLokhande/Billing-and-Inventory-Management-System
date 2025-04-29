package com.example.demo.model;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {
    private Integer invoiceId;
    private Integer orderId;
    private Float gst;
    private Float additionalCharges;
    private Double totalAmount;
    private Double dueAmount;
    private Timestamp issuedAt;
}
