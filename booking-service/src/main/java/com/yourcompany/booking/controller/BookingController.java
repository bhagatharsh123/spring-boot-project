package com.yourcompany.booking.controller;

import com.yourcompany.booking.dto.BookingRequest;
import com.yourcompany.booking.model.Booking;
import com.yourcompany.booking.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }
}
