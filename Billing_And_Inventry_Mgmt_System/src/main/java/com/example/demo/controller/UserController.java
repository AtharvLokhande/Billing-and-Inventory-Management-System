package com.example.demo.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeResponse;
import com.example.demo.model.Product;
import com.example.demo.model.Record;
import com.example.demo.model.UserRegistrationRequest;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        try {
            userService.registerUser(userRegistrationRequest);
            return "User registered successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to register user";
        }
    }

    @PostMapping("/login")
    public Map<String, String> loginUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        String role = userService.loginUser(username, password);

        Map<String, String> response = new HashMap<>();
        if (role != null) {
            response.put("role", role);
        } else {
            response.put("error", "Invalid credentials");
        }

        return response;
    }
    
    @GetMapping("/employees")
    public List<EmployeeResponse> getAllEmployees() {
        return userService.getAllEmployees();
    }
    
    @GetMapping("/testapi")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test endpoint hello");
    }
    
    @DeleteMapping("/delete-employee/{userId}")
    public String deleteEmployee(@PathVariable("userId") int userId) {
        boolean isDeleted = userService.deleteEmployeeById(userId);
        if (isDeleted) {
            return "Employee deleted successfully.";
        } else {
            return "Employee not found.";
        }
    }
    
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return userService.getAllProducts();
    }
    
    @PostMapping("/records")
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        Record savedRecord = userService.createRecord(record);
        return new ResponseEntity<>(savedRecord, HttpStatus.CREATED);
    }

  
}