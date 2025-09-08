package com.yourcompany.booking.controller;

import com.yourcompany.booking.dto.ReviewRequest;
import com.yourcompany.booking.model.Review;
import com.yourcompany.booking.service.ReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review addReview(@RequestBody ReviewRequest request) {
        return reviewService.addReview(request);
    }
}
