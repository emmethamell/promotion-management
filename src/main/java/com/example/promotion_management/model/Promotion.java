package com.example.promotion_management.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @ManyToOne
    @JoinColumn(name = "campaignId", nullable = false) //PromoCode entity is joined to Campaign entity via a foriegn key, the one in campaign
    private Campaign campaign;

    private String code;



}
