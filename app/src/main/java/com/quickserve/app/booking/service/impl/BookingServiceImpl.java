// FIX OPTION A (RECOMMENDED): Update BookingServiceImpl to implement ALL methods

package com.quickserve.app.booking.service.impl;

import com.quickserve.app.booking.dto.BookingRequest;
import com.quickserve.app.booking.entity.Booking;
import com.quickserve.app.booking.repository.BookingRepository;
import com.quickserve.app.booking.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(BookingRequest request) {

        OffsetDateTime start = request.getStartTime();
        OffsetDateTime end = start.plusHours(1);

        boolean conflict = bookingRepository.existsConflictingBooking(
                request.getProviderId(), start, end
        );

        if (conflict) {
            throw new RuntimeException("Time slot already booked");
        }

        Booking booking = new Booking();
        booking.setUserId(request.getUserId());
        booking.setProviderId(request.getProviderId());
        booking.setServiceListingId(request.getServiceListingId());
        booking.setStartTime(start);
        booking.setEndTime(end);
        booking.setStatus(Booking.BookingStatus.PENDING);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public void cancelBooking(Long bookingId) {
        Booking booking = getBookingById(bookingId);
        booking.setStatus(Booking.BookingStatus.CANCELLED);
        bookingRepository.save(booking);
    }
}
