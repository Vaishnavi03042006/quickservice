package com.quickserve.app.booking.service;

import com.quickserve.app.booking.dto.BookingRequest;
import com.quickserve.app.booking.entity.Booking;

import java.util.List;

public interface BookingService {

    Booking createBooking(BookingRequest request);

    List<Booking> getAllBookings();

    Booking getBookingById(Long id);

    void cancelBooking(Long id);
}