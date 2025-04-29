package com.example.demo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {
    private Integer profileId;
    private Integer userId;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String organization;
    private String designation;
}
