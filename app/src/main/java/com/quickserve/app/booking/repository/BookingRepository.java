package com.quickserve.app.booking.repository;

import com.quickserve.app.booking.entity.Booking;
import com.quickserve.app.booking.entity.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);

    List<Booking> findByProviderId(Long providerId);

    @Query("""
        SELECT b FROM Booking b
        WHERE b.providerId = :providerId
          AND b.startTime < :endTime
          AND b.endTime > :startTime
          AND b.status <> :cancelled
    """)
    List<Booking> findOverlappingBookings(
            Long providerId,
            OffsetDateTime startTime,
            OffsetDateTime endTime,
            BookingStatus cancelled
    );

    Optional<Booking> findByIdAndUserId(Long id, Long userId);
}
