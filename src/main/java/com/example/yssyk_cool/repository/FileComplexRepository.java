package com.example.yssyk_cool.repository;

import com.example.yssyk_cool.entity.FileComplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileComplexRepository extends JpaRepository<FileComplex,Long> {
}
