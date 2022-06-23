package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.location.request.LocationRequest;
import com.example.yssyk_cool.dto.location.response.LocationResponse;
import com.example.yssyk_cool.service.LocationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/location")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationController {

    final LocationService locationService;

    @PostMapping("/save")
    LocationResponse save(@RequestBody LocationRequest locationRequest){
        return null;
    }

    @GetMapping("/get-by-complex-id/{id}")
    LocationResponse getByComplexId(@PathVariable Long id){
        return null;
    }


}
