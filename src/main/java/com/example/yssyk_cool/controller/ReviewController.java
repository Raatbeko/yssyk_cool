package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.review.request.ReviewRequest;
import com.example.yssyk_cool.dto.review.response.ReviewResponse;
import com.example.yssyk_cool.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/review")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ReviewController {

    final ReviewService reviewService;

    @PostMapping("/save")
    ReviewResponse save(ReviewRequest request){
        return null;
    }

    @GetMapping("/get-by-complex-id/{id}")
    ReviewResponse getByComplexId(@PathVariable Long id){
        return null;
    }

    @GetMapping("/get-all-by-complex-id/{id}")
    List<ReviewResponse> getAllByComplexId(@PathVariable Long id){
        return null;
    }


}
