package com.example.promotion_management.service;
import com.example.promotion_management.repository.PromoCodeRepository;
import com.example.promotion_management.model.PromoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PromoCodeService {
    @Autowired
    private PromoCodeRepository promoCodeRepository;

    public List<PromoCode> getAllPromoCodes() {
        return promoCodeRepository.findAll();
    }

    public PromoCode getPromoCodeById(Long id) {
        Optional<PromoCode> promoCode = promoCodeRepository.findById(id);
        return promoCode.orElse(null);
    }

    public PromoCode createPromoCode(PromoCode promoCode) {
        return promoCodeRepository.save(promoCode);
    }

    public PromoCode updatePromoCode(Long id, PromoCode promoCodeDetails) {
        Optional<PromoCode> optionalPromoCode = promoCodeRepository.findById(id);

        if (optionalPromoCode.isPresent()) {
            PromoCode promoCode = optionalPromoCode.get();

            promoCode.setCode(promoCodeDetails.getCode());
            promoCode.setDiscountType(promoCodeDetails.getDiscountType());
            promoCode.setDiscountValue(promoCodeDetails.getDiscountValue());
            promoCode.setMinimumSpend(promoCodeDetails.getMinimumSpend());
            promoCode.setStartDate(promoCodeDetails.getStartDate());
            promoCode.setExpirationDate(promoCodeDetails.getExpirationDate());
            promoCode.setUsageLimit(promoCodeDetails.getUsageLimit());
            promoCode.setUsageCount(promoCodeDetails.getUsageCount());
            
            return promoCodeRepository.save(promoCode);
        } else {
            return null;
        }
    }

    public boolean deletePromoCode(Long id) {
        if (promoCodeRepository.existsById(id)) {
            promoCodeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    

}
