package com.example.demo.model;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    private Integer paymentId;
    private Integer invoiceId;
    private Double amountPaid;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private Timestamp paidAt;
}
