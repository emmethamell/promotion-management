package com.example.promotion_management.service;

import com.example.promotion_management.repository.CouponRepository;
import com.example.promotion_management.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    // Get all coupons
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    // Get a coupon by ID
    public Coupon getCouponById(Long id) {
        Optional<Coupon> coupon = couponRepository.findById(id);
        return coupon.orElse(null);
    }

    // Create a new coupon
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    // Update an existing coupon
    public Coupon updateCoupon(Long id, Coupon couponDetails) {
        Optional<Coupon> optionalCoupon = couponRepository.findById(id);

        if (optionalCoupon.isPresent()) {
            Coupon coupon = optionalCoupon.get();
            // Update the coupon details
            coupon.setCode(couponDetails.getCode());
            coupon.setDiscountAmount(couponDetails.getDiscountAmount());
            coupon.setMinimumSpend(couponDetails.getMinimumSpend());
            coupon.setStartDate(couponDetails.getStartDate());
            coupon.setExpirationDate(couponDetails.getExpirationDate());
            coupon.setUsageLimit(couponDetails.getUsageLimit());
            coupon.setUsageCount(couponDetails.getUsageCount());
            coupon.setCampaign(couponDetails.getCampaign()); // update campaign if needed
            
            // Save the updated coupon to the database
            return couponRepository.save(coupon);
        } else {
            return null;
        }
    }

    // Delete a coupon by ID
    public boolean deleteCoupon(Long id) {
        if (couponRepository.existsById(id)) {
            couponRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
