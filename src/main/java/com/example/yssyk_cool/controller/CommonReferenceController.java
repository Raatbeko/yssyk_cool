package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.commonReference.response.AreaResponse;
import com.example.yssyk_cool.dto.commonReference.response.CommonResponse;
import com.example.yssyk_cool.service.CommonReferenceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/common-reference")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class CommonReferenceController {

    final CommonReferenceService commonReferenceService;

    @GetMapping("/get-cities")
    public List<CommonResponse> getCities(){
        return commonReferenceService.getCities();
    }

    @GetMapping("/get-areas")
    public List<CommonResponse> getAreas(){
        return commonReferenceService.getAreas();
    }

}
