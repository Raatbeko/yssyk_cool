package com.example.yssyk_cool.mapper;

import com.example.yssyk_cool.dto.contactInfo.request.ContactInfoRequest;
import com.example.yssyk_cool.dto.contactInfo.response.ContactInfoResponse;
import com.example.yssyk_cool.entity.ContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactInfoMapper {

    ContactInfoMapper INSTANCE = Mappers.getMapper(ContactInfoMapper.class);

    List<ContactInfoResponse> toContactInfoResponse(List<ContactInfo> contactInfos);

    ContactInfoResponse toContactResponse(ContactInfo contactInfo);

    ContactInfoResponse toContactResponse(ContactInfoRequest contactInfoRequest);

}
