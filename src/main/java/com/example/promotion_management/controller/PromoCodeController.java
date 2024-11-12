package com.example.promotion_management.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.promotion_management.service.PromoCodeService;
import com.example.promotion_management.model.PromoCode;

import java.util.List;

@RestController
@RequestMapping("api/promocodes")
@CrossOrigin(origins = "http://localhost:5173") //allow requests from front end
public class PromoCodeController {
    @Autowired
    private PromoCodeService promoCodeService;

    @GetMapping
    public ResponseEntity<List<PromoCode>> getAllPromoCodes() {
        return ResponseEntity.ok(promoCodeService.getAllPromoCodes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromoCode> getPromoCodeById(@PathVariable Long id) {
        PromoCode promoCode = promoCodeService.getPromoCodeById(id);
        if (promoCode != null) {
            return ResponseEntity.ok(promoCode);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<PromoCode> createPromoCode(@RequestBody PromoCode promoCode) {
        PromoCode createdPromoCode = promoCodeService.createPromoCode(promoCode);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPromoCode);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromoCode> updatePromoCode(@PathVariable Long id, @RequestBody PromoCode promoCodeDetails) {
        PromoCode updatedPromoCode = promoCodeService.updatePromoCode(id, promoCodeDetails);
        if (updatedPromoCode != null) {
            return ResponseEntity.ok(updatedPromoCode);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromoCode(@PathVariable Long id) {
        boolean isDeleted = promoCodeService.deletePromoCode(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
