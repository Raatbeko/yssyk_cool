package com.example.yssyk_cool.service;

import com.example.yssyk_cool.dto.review.request.ReviewRequest;
import com.example.yssyk_cool.dto.review.response.ReviewResponse;
import com.example.yssyk_cool.entity.Complex;
import com.example.yssyk_cool.entity.Review;

import java.util.List;

public interface ReviewService extends BaseService<ReviewResponse, ReviewRequest>{

    List<ReviewResponse> getReviewsById(Complex complex);
}
