package com.example.yssyk_cool.repository;

import com.example.yssyk_cool.entity.CommonReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonReferenceRepository extends JpaRepository<CommonReference,Long> {

    List<CommonReference> findByTypeCode(Long codeType);

    CommonReference findByTitle(String title);


}
