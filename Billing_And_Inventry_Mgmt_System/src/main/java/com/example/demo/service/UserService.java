package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.model.Record;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service  
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;
    
    
   
    @Override
    public void registerUser(UserRegistrationRequest userRegistrationRequest) {
        userRepository.createUserAndProfile(
                userRegistrationRequest.getUsername(),
                userRegistrationRequest.getPassword(),
                userRegistrationRequest.getUserRoll(),
                userRegistrationRequest.getName(),
                userRegistrationRequest.getAddress(),
                userRegistrationRequest.getContact(),
                userRegistrationRequest.getEmail(),
                userRegistrationRequest.getOrganization(),
                userRegistrationRequest.getDesignation()
        );
    }
    
    @Override
    public String loginUser(String username, String password) {
        return userRepository.findUserRoleByUsernameAndPassword(username, password);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return userRepository.getAllEmployees();
    }

    @Override
    public boolean deleteEmployeeById(int userId) {
        return userRepository.deleteEmployeeById(userId);
    }

    @Override
    public List<Product> getAllProducts() {
        return userRepository.getAllProducts();
    }

    @Override
	public Record createRecord(Record record) {
		// TODO Auto-generated method stub
		return userRepository.save(record);
	}
    
 
}