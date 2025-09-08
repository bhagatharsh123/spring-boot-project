package com.yourcompany.booking.repository;

import com.yourcompany.booking.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
