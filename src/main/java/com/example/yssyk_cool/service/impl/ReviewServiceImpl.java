package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.review.request.ReviewRequest;
import com.example.yssyk_cool.dto.review.response.ReviewResponse;
import com.example.yssyk_cool.entity.Complex;
import com.example.yssyk_cool.entity.Review;
import com.example.yssyk_cool.exception.NotFoundException;
import com.example.yssyk_cool.mapper.ReviewMapper;
import com.example.yssyk_cool.repository.ComplexRepository;
import com.example.yssyk_cool.repository.ReviewRepository;
import com.example.yssyk_cool.repository.UserRepository;
import com.example.yssyk_cool.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewServiceImpl implements ReviewService {

    final ComplexRepository complexRepository;

    final ReviewRepository reviewRepository;

    final UserRepository userRepository;

    @Override
    @Transactional
    public ReviewResponse save(ReviewRequest t) {

        Review review = reviewRepository.save(Review.builder()
                .review(t.getReview())
                .grade(t.getGrade())
                .user(userRepository.findById(t.getUserId()).orElseThrow(() -> new NotFoundException("not found user", HttpStatus.NOT_FOUND)))
                .build());

        Complex complex = complexRepository.findById(t.getComplexId()).orElseThrow();
        complex.getReviews().add(review);
        complexRepository.save(complex);

        return ReviewMapper.INSTANCE.toReviewResponse(review);
    }

    @Override
    public ReviewResponse findById(Long id) {

        return ReviewMapper.INSTANCE.toReviewResponse(reviewRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found", HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<ReviewResponse> getAll() {
        return ReviewMapper.INSTANCE.toReviewResponse(reviewRepository.findAll());
    }


    @Override
    @Transactional
    public ReviewResponse delete(Long id) {

        Review review = reviewRepository.findById(id).orElseThrow();
        review.setDeletedAt(LocalDateTime.now());
        reviewRepository.save(review);

        return ReviewMapper.INSTANCE.toReviewResponse(review);
    }

    @Override
    public List<ReviewResponse> getReviewsById(Complex complex) {

        return ReviewMapper.INSTANCE.toReviewResponse(complex.getReviews());
    }
}

