package com.example.demo.model;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private Integer orderId;
    private OrderType orderType;
    private Integer customerId;
    private Integer supplierId;
    private OrderStatus orderStatus;
    private Timestamp orderedAt;
}
