package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.contactInfo.request.ContactInfoRequest;
import com.example.yssyk_cool.dto.contactInfo.response.ContactInfoResponse;
import com.example.yssyk_cool.service.ContactInfoService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController("api/contact/")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactInfoController {

    final ContactInfoService contactInfoService;

    @PostMapping("/save")
    ContactInfoResponse save(@RequestBody ContactInfoRequest contactInfoRequest){
        return null;
    }

    @GetMapping("/get-by-id/{id}")
    ContactInfoResponse getByComplexId(@PathVariable Long id){
        return null;
    }

}
