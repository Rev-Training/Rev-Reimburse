package com.example.demo.enums;

public enum RequestStatus {
    PENDING("PENDING"),
    DENIED("DENIED"),
    APPROVED("APPROVED");

    private final String status;

    RequestStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}

