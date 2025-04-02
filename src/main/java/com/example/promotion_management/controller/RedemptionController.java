package com.example.promotion_management.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.promotion_management.service.RedemptionService;
import com.example.promotion_management.model.Coupon;
import com.example.promotion_management.model.PromoCode;
import com.example.promotion_management.model.Redemption;
import com.example.promotion_management.model.User;

@RequestMapping("api/redemptions")
public class RedemptionController {
    @Autowired
    private RedemptionService redemptionService;

    @PostMapping("/promoCode")
    public ResponseEntity<Redemption> redeemPromoCode(@RequestParam Long userId, @RequestParam Long promoCodeId) {
        Redemption redemption = redemptionService.redeemPromoCode(userId, promoCodeId);

        return new ResponseEntity<>(redemption, HttpStatus.CREATED);
    }

    @PostMapping("/coupon")
    public ResponseEntity<Redemption> redeemCoupon(@RequestParam Long userId, @RequestParam Long couponId) {
        Redemption redemption = redemptionService.redeemCoupon(userId, couponId);

        return new ResponseEntity<>(redemption, HttpStatus.CREATED);
    }

}
