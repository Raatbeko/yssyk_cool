package com.example.yssyk_cool.service;

import com.example.yssyk_cool.dto.commonReference.request.CommonReferenceRequest;
import com.example.yssyk_cool.dto.commonReference.response.AreaResponse;
import com.example.yssyk_cool.dto.commonReference.response.CityResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CommonReferenceService {

   List<CityResponse> getCities();

    List<AreaResponse> getAreas();
}
