package com.example.yssyk_cool.service;

import com.example.yssyk_cool.dto.contactInfo.request.ContactInfoForUpdateRequest;
import com.example.yssyk_cool.dto.contactInfo.request.ContactInfoRequest;
import com.example.yssyk_cool.entity.ContactInfo;

public interface ContactInfoService extends BaseService<ContactInfo, ContactInfoRequest>{
    ContactInfo update(ContactInfoForUpdateRequest contactInfoRequest);
}
