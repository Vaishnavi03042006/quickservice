package com.quickserve.app.booking.controller;

import com.quickserve.app.booking.dto.BookingRequest;
import com.quickserve.app.booking.entity.Booking;
import com.quickserve.app.booking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking create(@RequestBody BookingRequest request) {
        // TEMP values (JWT later)
        System.out.println("Controller reached");
        return bookingService.createBooking(1L, 10L, request);
    }

    @GetMapping
    public List<Booking> myBookings() {
        return bookingService.getBookingsForUser(1L);
    }

    @PutMapping("/{id}/cancel")
    public String cancel(@PathVariable Long id) {
        bookingService.cancelBooking(id, 1L);
        return "Booking cancelled";
    }
}
