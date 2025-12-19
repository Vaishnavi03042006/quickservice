package com.quickserve.app.calendar.repository;

import com.quickserve.app.calendar.entity.CalendarAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.List;

public interface CalendarAvailabilityRepository
        extends JpaRepository<CalendarAvailability, Long> {

    @Query("""
        SELECT a FROM CalendarAvailability a
        WHERE a.serviceListingId = :listingId
          AND a.startTime <= :start
          AND a.endTime >= :end
    """)
    List<CalendarAvailability> findMatchingAvailability(
            Long listingId,
            OffsetDateTime start,
            OffsetDateTime end
    );
}
