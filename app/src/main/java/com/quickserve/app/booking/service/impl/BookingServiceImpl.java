package com.quickserve.app.booking.service.impl;

import com.quickserve.app.booking.dto.BookingRequest;
import com.quickserve.app.booking.entity.Booking;
import com.quickserve.app.booking.entity.BookingStatus;
import com.quickserve.app.booking.repository.BookingRepository;
import com.quickserve.app.booking.service.BookingService;
import com.quickserve.app.calendar.repository.CalendarAvailabilityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CalendarAvailabilityRepository availabilityRepository;

    public BookingServiceImpl(
            BookingRepository bookingRepository,
            CalendarAvailabilityRepository availabilityRepository) {
        this.bookingRepository = bookingRepository;
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public Booking createBooking(Long userId, Long providerId, BookingRequest request) {

        if (availabilityRepository.findMatchingAvailability(
                request.getServiceListingId(),
                request.getStartTime(),
                request.getEndTime()
        ).isEmpty()) {
            throw new RuntimeException("Service not available for selected time");
        }

        if (!bookingRepository.findOverlappingBookings(
                providerId,
                request.getStartTime(),
                request.getEndTime(),
                BookingStatus.CANCELLED
        ).isEmpty()) {
            throw new RuntimeException("Time slot already booked");
        }

        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setProviderId(providerId);
        booking.setServiceListingId(request.getServiceListingId());
        booking.setStartTime(request.getStartTime());
        booking.setEndTime(request.getEndTime());
        booking.setStatus(BookingStatus.PENDING);

        return bookingRepository.save(booking);
    }

    @Override
    public void cancelBooking(Long bookingId, Long userId) {
        Booking booking = bookingRepository.findByIdAndUserId(bookingId, userId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.CANCELLED);
    }

    @Override
    public List<Booking> getBookingsForUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}
