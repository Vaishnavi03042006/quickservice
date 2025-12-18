package com.quickserve.app.booking.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long providerId;
    private Long serviceListingId;

    private OffsetDateTime startTime;
    private OffsetDateTime endTime;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        COMPLETED,
        CANCELLED
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getProviderId() { return providerId; }
    public Long getServiceListingId() { return serviceListingId; }
    public OffsetDateTime getStartTime() { return startTime; }
    public OffsetDateTime getEndTime() { return endTime; }
    public BookingStatus getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setProviderId(Long providerId) { this.providerId = providerId; }
    public void setServiceListingId(Long serviceListingId) { this.serviceListingId = serviceListingId; }
    public void setStartTime(OffsetDateTime startTime) { this.startTime = startTime; }
    public void setEndTime(OffsetDateTime endTime) { this.endTime = endTime; }
    public void setStatus(BookingStatus status) { this.status = status; }
}
