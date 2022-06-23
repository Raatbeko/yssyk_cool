package com.example.yssyk_cool.repository;

import com.example.yssyk_cool.entity.CommonReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonReferenceRepository extends JpaRepository<CommonReference,Long> {

}
