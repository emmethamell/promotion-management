package com.example.promotion_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.promotion_management.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
