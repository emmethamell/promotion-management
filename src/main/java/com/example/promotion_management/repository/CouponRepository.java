package com.example.promotion_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.promotion_management.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    
}
