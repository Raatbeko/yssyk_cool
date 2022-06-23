package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.review.request.ReviewRequest;
import com.example.yssyk_cool.dto.review.response.ReviewResponse;
import com.example.yssyk_cool.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewServiceImpl implements ReviewService {

    @Override
    public ReviewResponse save(ReviewRequest t) {
        return null;
    }

    @Override
    public List<ReviewResponse> getAll() {
        return null;
    }

    @Override
    public ReviewResponse findById(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
