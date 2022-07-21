package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.review.request.ReviewRequest;
import com.example.yssyk_cool.dto.review.response.ReviewResponse;
import com.example.yssyk_cool.entity.Complex;
import com.example.yssyk_cool.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
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
    @ApiOperation("Добавить отзыв для комплекса")
    public ReviewResponse save(@RequestBody ReviewRequest request) throws FileNotFoundException {
        return reviewService.save(request);
    }

    @GetMapping("/get-all-by-complex-id/{id}")
    @ApiOperation("Получить все отзывы по id комплекса")
    public List<ReviewResponse> getAllByComplexId(@PathVariable("id") Complex complex){
        return reviewService.getAllByComplexId(complex);
    }
}
