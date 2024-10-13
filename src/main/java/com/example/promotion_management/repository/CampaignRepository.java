package com.example.promotion_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.promotion_management.model.Campaign;

// provides set of built-in methods for working with campaign entities
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    // additional custom queries can be put here as needed
}
