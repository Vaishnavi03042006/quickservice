package com.quickserve.app.calendar.repository;

import com.quickserve.app.calendar.entity.CalendarAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarAvailabilityRepository extends JpaRepository<CalendarAvailability, Long> {
}
