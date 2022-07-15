package com.example.yssyk_cool.mapper.location.impl;

import com.example.yssyk_cool.dto.location.response.LocationResponse;
import com.example.yssyk_cool.entity.Location;
import com.example.yssyk_cool.mapper.location.LocationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationResponse toLocationResponse(Location location) {
    return LocationResponse.builder()
                .id(location.getId())
                .city(location.getCity().getTitle())
                .area(location.getArea()!= null ? location.getArea().getTitle() : "")
                .streetName(location.getStreetName())
                .urlGoogleMap(location.getUrlGoogleMap())
                .build();
    }

    @Override
    public List<LocationResponse> toListLocationResponse(List<Location> locations) {
        return locations.stream()
                .map(location -> LocationResponse.builder()
                        .area(location.getArea()!= null ? location.getArea().getTitle() : "")
                        .id(location.getId())
                        .streetName(location.getStreetName())
                        .city(location.getCity().getTitle())
                        .urlGoogleMap(location.getUrlGoogleMap())
                        .build()).collect(Collectors.toList());
    }

}
