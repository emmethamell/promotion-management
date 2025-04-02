package com.example.promotion_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.promotion_management.model.Redemption;

public interface RedemptionRepository extends JpaRepository<Redemption, Long>{
    boolean existsByUserUidAndPromoCodeUid(Long userUid, Long promoCodeUid);
}
