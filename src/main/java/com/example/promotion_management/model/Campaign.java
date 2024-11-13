package com.example.promotion_management.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.example.promotion_management.enums.Status;

@Entity //annotation tells JPA that this class should be matched to a database table, an instance of campaign should be matched to a row in the campaign database
public class Campaign { 
    @Id //marks the campaignID as the primary ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generates an ID
    private Long campaignId;
    
    //the basic fields for a campaign instance
    private String campaignName;
    private String campaignDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private String createdBy;
    private Status status; // "active, paused or completed"

    @OneToMany(mappedBy = "campaign") // campaign can have many promoCodes
    @JsonManagedReference
    private List<PromoCode> promoCodes;

    @OneToMany(mappedBy = "campaign") // campaign can have many coupons
    @JsonManagedReference
    private List<Coupon> coupons;

    //getters and setters
    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignDescription() {
        return campaignDescription;
    }

    public void setCampaignDescription(String campaignDescription) {
        this.campaignDescription = campaignDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<PromoCode> getPromoCodes() {
        return promoCodes;
    }

    public void setPromoCodes(List<PromoCode> promoCodes) {
        this.promoCodes = promoCodes;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
    
}
