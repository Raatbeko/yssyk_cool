package com.example.yssyk_cool.service.impl;

import com.example.yssyk_cool.dto.location.request.LocationRequest;
import com.example.yssyk_cool.dto.location.response.LocationResponse;
import com.example.yssyk_cool.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    @Override
    public LocationResponse save(LocationRequest t) {
        return null;
    }

    @Override
    public List<LocationResponse> getAll() {
        return null;
    }

    @Override
    public LocationResponse findById(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
