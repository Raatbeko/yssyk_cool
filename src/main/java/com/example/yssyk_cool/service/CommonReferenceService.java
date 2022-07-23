package com.example.yssyk_cool.service;

import com.example.yssyk_cool.dto.commonReference.response.AreaResponse;
import com.example.yssyk_cool.dto.commonReference.response.CommonResponse;
import com.example.yssyk_cool.entity.CommonReference;

import java.util.List;

public interface CommonReferenceService {

   List<CommonResponse> getCities();

    List<CommonResponse> getAreas();

    CommonReference getByTitle(String title);

    CommonReference getByCode(Long code);

    List<CommonResponse> getTypeComplex();
}
