package com.quickserve.app.booking.repository;

import com.quickserve.app.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("""
        SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END
        FROM Booking b
        WHERE b.providerId = :providerId
          AND b.startTime < :endTime
          AND b.endTime > :startTime
          AND b.status <> 'CANCELLED'
    """)
    boolean existsConflictingBooking(
            Long providerId,
            OffsetDateTime startTime,
            OffsetDateTime endTime
    );
}
