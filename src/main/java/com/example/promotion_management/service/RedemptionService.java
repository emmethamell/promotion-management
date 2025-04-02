package com.example.promotion_management.service;

import com.example.promotion_management.model.Redemption;
import com.example.promotion_management.model.PromoCode;
import com.example.promotion_management.model.Coupon;
import com.example.promotion_management.model.User;
import com.example.promotion_management.repository.RedemptionRepository;
import com.example.promotion_management.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class RedemptionService {
    @Autowired
    private RedemptionRepository redemptionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PromoCodeService promoCodeService;

    @Autowired
    private CouponService couponService;

    public Redemption redeemPromoCode(Long userId, Long promoCodeId) {
        PromoCode promoCode = promoCodeService.getPromoCodeById(promoCodeId);
        User user = userService.getUserById(userId);
        
        // Validate promo code
        if (promoCode == null) {
            throw new IllegalArgumentException("PromoCode not found");
        }
        
        // Check if already redeemed
        if (isAlreadyRedeemed(userId, promoCodeId)) {
            throw new IllegalStateException("PromoCode already redeemed by user");
        }
        
        // Check expiration
        if (LocalDate.now().isAfter(promoCode.getExpirationDate())) {
            throw new IllegalStateException("PromoCode has expired");
        }
        
        // Check usage limit
        if (promoCode.getUsageCount() >= promoCode.getUsageLimit()) {
            throw new IllegalStateException("PromoCode usage limit reached");
        }

        // Create redemption
        Redemption redemption = new Redemption();
        redemption.setUser(user);
        redemption.setPromoCode(promoCode);
        redemption.setCampaign(promoCode.getCampaign());
        redemption.setRedemptionDate(LocalDate.now());
        redemption.setDiscountAmount(promoCode.getDiscountValue());

        // Update promo code usage count
        promoCode.setUsageCount(promoCode.getUsageCount() + 1);
        promoCodeService.updatePromoCode(promoCodeId, promoCode);

        return redemptionRepository.save(redemption);
    }

    public Redemption redeemCoupon(Long userId, Long couponId) {
        Coupon coupon = couponService.getCouponById(couponId);
        User user = userService.getUserById(userId);
        
        // Similar validation as promo code
        if (coupon == null) {
            throw new IllegalArgumentException("Coupon not found");
        }
        
        if (LocalDate.now().isAfter(coupon.getExpirationDate())) {
            throw new IllegalStateException("Coupon has expired");
        }
        
        if (coupon.getUsageCount() >= coupon.getUsageLimit()) {
            throw new IllegalStateException("Coupon usage limit reached");
        }

        Redemption redemption = new Redemption();
        redemption.setUser(user);
        redemption.setCoupon(coupon);
        redemption.setCampaign(coupon.getCampaign());
        redemption.setRedemptionDate(LocalDate.now());
        redemption.setDiscountAmount(coupon.getDiscountAmount());

        // Update coupon usage count
        coupon.setUsageCount(coupon.getUsageCount() + 1);
        couponService.updateCoupon(couponId, coupon);

        return redemptionRepository.save(redemption);
    }

    public boolean isAlreadyRedeemed(Long userUid, Long promoCodeUid) {
        // Implement logic to check for existing redemption
        return redemptionRepository.existsByUserUidAndPromoCodeUid(userUid, promoCodeUid);
    }
}
