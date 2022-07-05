package com.example.yssyk_cool.endpoint.impl;

import com.example.yssyk_cool.dto.location.request.LocationRequest;
import com.example.yssyk_cool.dto.location.response.LocationResponse;
import com.example.yssyk_cool.endpoint.LocationEndpoint;
import com.example.yssyk_cool.entity.Location;
import com.example.yssyk_cool.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationEndpointImpl implements LocationEndpoint {

    final LocationService locationService;

    @Override
    public LocationResponse save(LocationRequest t) {

        Location location = locationService.save(t);

        return LocationResponse.builder()
                .id(location.getId())
                .city(location.getCity().getTitle())
                .area(location.getArea().getTitle())
                .streetName(location.getStreetName())
                .urlGoogleMap(location.getUrlGoogleMap())
                .build();
    }

    @Override
    public List<LocationResponse> getAll() {
        return locationService.getAll().stream()
                .map(location -> LocationResponse.builder()
                        .area(location.getArea().getTitle())
                        .id(location.getId())
                        .streetName(location.getStreetName())
                        .city(location.getCity().getTitle())
                        .urlGoogleMap(location.getUrlGoogleMap())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public LocationResponse findById(Long id) {
        Location location = locationService.findById(id);
        return LocationResponse.builder()
                .id(location.getId())
                .city(location.getCity().getTitle())
                .area(location.getArea()!=null?location.getArea().getTitle():"")
                .streetName(location.getStreetName())
                .urlGoogleMap(location.getUrlGoogleMap())
                .build();
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
