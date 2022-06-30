package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.contactInfo.request.ContactInfoRequest;
import com.example.yssyk_cool.dto.contactInfo.response.ContactInfoResponse;
import com.example.yssyk_cool.entity.ContactInfo;
import com.example.yssyk_cool.exception.NotFoundException;
import com.example.yssyk_cool.mapper.ContactInfoMapper;
import com.example.yssyk_cool.repository.ComplexRepository;
import com.example.yssyk_cool.repository.ContactInfoRepository;
import com.example.yssyk_cool.service.ContactInfoService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactInfoServiceImpl implements ContactInfoService {

    final ContactInfoRepository contactInfoRepository;

    @Override
    public ContactInfo save(ContactInfoRequest t) {
        return  contactInfoRepository.save(ContactInfo.builder()
                .email(t.getEmail())
                .phoneNumber(t.getPhoneNumber())
                .telegramAccountName(t.getTelegramAccountName())
                .build());
    }

    @Override
    public List<ContactInfo> getAll() {
        return contactInfoRepository.findAll();
    }

    @Override
    public ContactInfo findById(Long id) {
        return contactInfoRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
