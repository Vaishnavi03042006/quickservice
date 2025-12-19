package com.quickserve.app.calendar.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "calendar_availability")
public class CalendarAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long providerId;
    private Long serviceListingId;

    private OffsetDateTime startTime;
    private OffsetDateTime endTime;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public Long getProviderId() {
        return providerId;
    }

    public Long getServiceListingId() {
        return serviceListingId;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public void setServiceListingId(Long serviceListingId) {
        this.serviceListingId = serviceListingId;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }
}
