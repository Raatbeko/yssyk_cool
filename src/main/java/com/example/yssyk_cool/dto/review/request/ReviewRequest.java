package com.example.yssyk_cool.dto.review.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewRequest {
    @NotNull
    Long postId;

    Long userId;

    String review;

    @NotNull
    Long grade;
}
