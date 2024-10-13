package com.example.promotion_management.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Redemption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @ManyToOne
    @JoinColumn(name = "campaignId", nullable = false)
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "promoCodeId", nullable = true)
    private PromoCode promoCode;

    @ManyToOne
    @JoinColumn(name = "couponId", nullable = true)
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    private LocalDate redemptionDate;
    private BigDecimal discountAmount;

   
}