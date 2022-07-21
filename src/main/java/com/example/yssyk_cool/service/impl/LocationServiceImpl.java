package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.location.request.LocationForUpdateRequest;
import com.example.yssyk_cool.dto.location.request.LocationRequest;
import com.example.yssyk_cool.entity.Location;
import com.example.yssyk_cool.exception.NotFoundException;
import com.example.yssyk_cool.repository.LocationRepository;
import com.example.yssyk_cool.service.CommonReferenceService;
import com.example.yssyk_cool.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    final LocationRepository locationRepository;

    final CommonReferenceService commonReferenceService;

    @Override
    public Location save(LocationRequest t) {
        return locationRepository.save(Location.builder()
                .area(commonReferenceService.getByTitle(t.getArea()))
                .city(commonReferenceService.getByTitle(t.getCity()))
                .streetName(t.getStreetName())
                .urlGoogleMap(t.getUrlGoogleMap())
                .build());
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Location delete(Long id) {
        return null;
    }

    @Override
    public Location update(LocationForUpdateRequest locationForUpdateRequest) {
        Location location = findById(locationForUpdateRequest.getLocationId());
        location.setArea(commonReferenceService.getByTitle(locationForUpdateRequest.getArea()));
        location.setCity(commonReferenceService.getByTitle(locationForUpdateRequest.getCity()));
        location.setStreetName(locationForUpdateRequest.getStreetName());
        location.setUrlGoogleMap(locationForUpdateRequest.getUrlGoogleMap());
        return locationRepository.save(location);
    }
}
