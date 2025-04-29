package com.example.demo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Integer productId;
    private String name;
    private Integer supplierId;
    private Integer quantity;
    private Double price;
    private Float gstPercentage;
    private String description;
    private String brand;
    private String category;
}
