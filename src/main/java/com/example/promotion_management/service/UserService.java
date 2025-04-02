package com.example.promotion_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.promotion_management.model.User;
import com.example.promotion_management.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to find a user by ID
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
    }
    
    // Method to create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Method to update user information
    public User updateUser(Long userId, User userDetails) {
        User user = getUserById(userId);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        
        return userRepository.save(user);
    }

    // Method to delete a user by ID
    public void deleteUser(Long userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }
}
