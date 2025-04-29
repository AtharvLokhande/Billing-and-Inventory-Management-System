package com.example.demo.model;

import lombok.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer userId;
    private UserRole userRoll;
    private String username;
    private String password;
    private Timestamp createdAt;
	public Object getProfile() {
		// TODO Auto-generated method stub
		return null;
	}
}
