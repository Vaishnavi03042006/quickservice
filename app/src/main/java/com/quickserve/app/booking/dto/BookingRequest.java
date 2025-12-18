package com.quickserve.app.booking.dto;

import java.time.OffsetDateTime;

public class BookingRequest {

    private Long userId;
    private Long providerId;
    private Long serviceListingId;

    private OffsetDateTime startTime;   // UTC
    private OffsetDateTime endTime;     // UTC

    private String status; // PENDING, CONFIRMED, etc.

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getServiceListingId() {
        return serviceListingId;
    }

    public void setServiceListingId(Long serviceListingId) {
        this.serviceListingId = serviceListingId;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
