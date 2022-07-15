package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.review.request.ReviewRequest;
import com.example.yssyk_cool.dto.review.response.ReviewResponse;
import com.example.yssyk_cool.entity.Complex;
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
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class ReviewController {

    final ReviewService reviewService;

    @PostMapping("/save")
    public ReviewResponse save(@RequestBody ReviewRequest request){
        return reviewService.save(request);
    }

    @GetMapping("/{id}")
    public ReviewResponse getByComplexId(@PathVariable("id") Long id){
        return reviewService.findById(id);
    }

    @GetMapping("/get-all-by-complex-id/{id}")
    public List<ReviewResponse> getAllByComplexId(@PathVariable("id") Complex complex){
        return reviewService.getAllByComplexId(complex);
    }
}
