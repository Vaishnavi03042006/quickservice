package com.quickserve.app.booking.service;

import com.quickserve.app.booking.dto.BookingRequest;
import com.quickserve.app.booking.entity.Booking;

import java.util.List;

public interface BookingService {

    Booking createBooking(Long userId, Long providerId, BookingRequest request);

    void cancelBooking(Long bookingId, Long userId);

    List<Booking> getBookingsForUser(Long userId);
}
