package com.example.yssyk_cool.endpoint.impl;

import com.example.yssyk_cool.dto.complex.request.ComplexRequest;
import com.example.yssyk_cool.dto.complex.response.ComplexResponse;
import com.example.yssyk_cool.endpoint.ComplexEndpoint;
import com.example.yssyk_cool.endpoint.ContactInfoEndpoint;
import com.example.yssyk_cool.endpoint.LocationEndpoint;
import com.example.yssyk_cool.entity.Complex;
import com.example.yssyk_cool.service.ComplexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComplexEndpointImpl implements ComplexEndpoint {

    final ComplexService complexService;

    final ContactInfoEndpoint contactInfoEndpoint;

    final LocationEndpoint locationEndpoint;

    @Override
    public ComplexResponse save(ComplexRequest t) {
        Complex complex = complexService.save(t);
        return ComplexResponse.builder()
                .id(complex.getId())
                .averagePrice(complex.getAveragePrice())
                .name(complex.getComplexName())
                .userId(complex.getUser().getId())
                .contactInfoResponse(contactInfoEndpoint.findById(complex.getId()))
                .fileResponses(complexService.getAllFile(complex.getId()))
                .locationResponse(locationEndpoint.findById(complex.getLocation().getId())
                ).build();
    }

    @Override
    public List<ComplexResponse> getAll() {
        return complexService.getAll().stream()
                .map(complex -> ComplexResponse.builder()
                        .id(complex.getId())
                        .averagePrice(complex.getAveragePrice())
                        .name(complex.getComplexName())
                        .userId(complex.getUser().getId())
                        .contactInfoResponse(contactInfoEndpoint.findById(complex.getId()))
                        .fileResponses(complexService.getAllFile(complex.getId()))
                        .locationResponse(locationEndpoint.findById(complex.getLocation().getId())
                        ).build()).collect(Collectors.toList());
    }

    @Override
    public ComplexResponse findById(Long id) {
        Complex complex = complexService.findById(id);
        return ComplexResponse.builder()
                .id(complex.getId())
                .averagePrice(complex.getAveragePrice())
                .name(complex.getComplexName())
                .userId(complex.getUser().getId())
                .contactInfoResponse(contactInfoEndpoint.findById(complex.getId()))
                .fileResponses(complexService.getAllFile(complex.getId()))
                .locationResponse(locationEndpoint.findById(complex.getLocation().getId())
                ).build();
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public List<ComplexResponse> findAllByUserId(Long id) {
        return complexService.findAllByUserId(id).stream()
                .map(complex -> ComplexResponse.builder()
                        .id(complex.getId())
                        .averagePrice(complex.getAveragePrice())
                        .name(complex.getComplexName())
                        .userId(complex.getUser().getId())
                        .contactInfoResponse(contactInfoEndpoint.findById(complex.getId()))
                        .fileResponses(complexService.getAllFile(complex.getId()))
                        .locationResponse(locationEndpoint.findById(complex.getLocation().getId())
                        ).build()).collect(Collectors.toList());
    }
}
