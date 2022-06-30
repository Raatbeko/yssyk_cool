package com.example.yssyk_cool.endpoint.impl;

import com.example.yssyk_cool.dto.contactInfo.request.ContactInfoRequest;
import com.example.yssyk_cool.dto.contactInfo.response.ContactInfoResponse;
import com.example.yssyk_cool.endpoint.ContactInfoEndpoint;
import com.example.yssyk_cool.entity.ContactInfo;
import com.example.yssyk_cool.mapper.ContactInfoMapper;
import com.example.yssyk_cool.service.ContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactInfoEndpointImpl implements ContactInfoEndpoint {

    final ContactInfoService contactInfoService;

    @Override
    public ContactInfoResponse save(ContactInfoRequest t) {

        ContactInfo contactInfo = contactInfoService.save(t);

        return ContactInfoMapper.INSTANCE.toContactResponse(contactInfo);
    }

    @Override
    public List<ContactInfoResponse> getAll() {

        return ContactInfoMapper.INSTANCE.toContactInfoResponse(contactInfoService.getAll());
    }

    @Override
    public ContactInfoResponse findById(Long id) {
        return ContactInfoMapper.INSTANCE.toContactResponse(contactInfoService.findById(id));
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
