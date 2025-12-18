package com.quickserve.app.calendar.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "calendar_availability")
public class CalendarAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long providerId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Long getId() { return id; }
    public Long getProviderId() { return providerId; }
    public LocalDate getDate() { return date; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }

    public void setId(Long id) { this.id = id; }
    public void setProviderId(Long providerId) { this.providerId = providerId; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
}
