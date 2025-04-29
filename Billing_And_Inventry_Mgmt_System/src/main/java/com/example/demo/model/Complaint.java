package com.example.demo.model;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Complaint {
    private Integer complaintId;
    private Integer customerId;
    private Integer productId;
    private String description;
    private ComplaintStatus status;
    private Timestamp createdAt;
}
