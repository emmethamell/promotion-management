package com.example.promotion_management.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @ManyToOne
    @JoinColumn(name = "campaignId", nullable = false)
    private Campaign campaign;

    private String code;
    private BigDecimal discountAmount;
    private BigDecimal minimumSpend;
    private LocalDate expirationDate;
    private Integer usageLimit;
    private Integer usageCount;

   
}
