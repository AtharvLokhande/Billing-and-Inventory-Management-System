package com.example.demo.repository;

import com.example.demo.model.*;
import com.example.demo.model.Record;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {
    void createUserAndProfile(String username, String password, String userRoll,
                            String name, String address, String contact,
                            String email, String organization, String designation);
    
    String findUserRoleByUsernameAndPassword(String username, String password);
    
    List<EmployeeResponse> getAllEmployees();
    
    boolean deleteEmployeeById(int userId);
    
    List<Product> getAllProducts();

	Record save(Record record);
 
}