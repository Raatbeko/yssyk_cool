package com.example.yssyk_cool.repository;

import com.example.yssyk_cool.entity.CommonReferenceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonReferenceTypeRepository extends JpaRepository<CommonReferenceType,Long> {
}
