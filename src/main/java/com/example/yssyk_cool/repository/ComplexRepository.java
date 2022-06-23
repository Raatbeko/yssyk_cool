package com.example.yssyk_cool.repository;

import com.example.yssyk_cool.entity.Complex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplexRepository extends JpaRepository<Complex,Long> {
}
