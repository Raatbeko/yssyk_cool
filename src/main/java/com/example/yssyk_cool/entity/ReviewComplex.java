package com.example.yssyk_cool.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "review_complexes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewComplex extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "review_id",nullable = false)
    Review review;

    @ManyToOne
    @JoinColumn(name = "complex_id",nullable = false)
    Complex complexes;


}
