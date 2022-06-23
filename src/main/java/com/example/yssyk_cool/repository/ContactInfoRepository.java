package com.example.yssyk_cool.repository;

import com.example.yssyk_cool.entity.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo,Long> {
}
