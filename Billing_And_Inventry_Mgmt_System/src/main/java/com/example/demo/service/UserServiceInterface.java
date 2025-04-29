package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.model.Record;

import java.util.List;

public interface UserServiceInterface {
    void registerUser(UserRegistrationRequest userRegistrationRequest);
    String loginUser(String username, String password);
    List<EmployeeResponse> getAllEmployees();
    boolean deleteEmployeeById(int userId);
    List<Product> getAllProducts();
	Record createRecord(Record record);
   
}