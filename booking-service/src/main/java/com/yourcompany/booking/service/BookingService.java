package com.yourcompany.booking.service;

import com.yourcompany.booking.dto.BookingRequest;
import com.yourcompany.booking.model.Booking;
import com.yourcompany.booking.model.Provider;
import com.yourcompany.booking.repository.BookingRepository;
import com.yourcompany.booking.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ProviderRepository providerRepository;

    // ✅ Constructor Injection
    public BookingService(BookingRepository bookingRepository, ProviderRepository providerRepository) {
        this.bookingRepository = bookingRepository;
        this.providerRepository = providerRepository;
    }

    public Booking createBooking(BookingRequest request) {
        Provider provider = providerRepository.findById(request.getProviderId())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        Booking booking = new Booking();
        booking.setUserId(request.getUserId());
        booking.setProvider(provider);
        booking.setBookingTime(LocalDateTime.now());

        return bookingRepository.save(booking);
    }
}
