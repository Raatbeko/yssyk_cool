package com.example.yssyk_cool.repository;

import com.example.yssyk_cool.entity.Complex;
import com.example.yssyk_cool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplexRepository extends JpaRepository<Complex,Long>{

    List<Complex> findAllByUserId(Long id);

    Complex findByComplexName(String complexName);

}
