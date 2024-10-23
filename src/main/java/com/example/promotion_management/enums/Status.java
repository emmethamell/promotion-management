package com.example.promotion_management.enums;
public enum Status {
    ACTIVE("Active"),
    PENDING("Paused"),
    COMPLETED("Completed");

    private final String Status;

    Status(String Status) {
        this.Status = Status;
    }
}
