package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeeResponse {
	
	    private int userId;
	    private String username;
	    private String name;
	    private String address;
	    private String contact;
	    private String email;
	    private String organization;
	    private String userroll;

}
