package com.example.yssyk_cool.service;

import com.example.yssyk_cool.dto.commonReference.response.AreaResponse;
import com.example.yssyk_cool.dto.commonReference.response.CityResponse;
import com.example.yssyk_cool.entity.CommonReference;

import java.util.List;

public interface CommonReferenceService {

   List<CityResponse> getCities();

    List<AreaResponse> getAreas();

    CommonReference getByTitle(String title);

    CommonReference getByCode(Long code);
}
