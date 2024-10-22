package com.example.promotion_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.promotion_management.model.PromoCode;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {
    
}
