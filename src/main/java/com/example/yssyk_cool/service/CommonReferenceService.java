package com.example.yssyk_cool.service;

import com.example.yssyk_cool.dto.commonReference.response.AreaResponse;
import com.example.yssyk_cool.dto.commonReference.response.CityResponse;

import java.util.List;

public interface CommonReferenceService {

   List<CityResponse> getCities();

    List<AreaResponse> getAreas();
}
