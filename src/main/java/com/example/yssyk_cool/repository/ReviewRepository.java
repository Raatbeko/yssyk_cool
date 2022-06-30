package com.example.yssyk_cool.repository;

import com.example.yssyk_cool.entity.Complex;
import com.example.yssyk_cool.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findAllByComplexId(Complex complex);

    Review findByComplexId(Complex complexId);
}
