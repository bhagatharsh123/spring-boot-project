package com.yourcompany.booking.service;

import com.yourcompany.booking.dto.ReviewRequest;
import com.yourcompany.booking.model.Provider;
import com.yourcompany.booking.model.Review;
import com.yourcompany.booking.repository.ProviderRepository;
import com.yourcompany.booking.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProviderRepository providerRepository;

    // ✅ Constructor Injection
    public ReviewService(ReviewRepository reviewRepository, ProviderRepository providerRepository) {
        this.reviewRepository = reviewRepository;
        this.providerRepository = providerRepository;
    }

    public Review addReview(ReviewRequest request) {
        Provider provider = providerRepository.findById(request.getProviderId())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        Review review = new Review();
        review.setUserId(request.getUserId());
        review.setComment(request.getComment());
        review.setRating(request.getRating());
        review.setProvider(provider);

        return reviewRepository.save(review);
    }
}
