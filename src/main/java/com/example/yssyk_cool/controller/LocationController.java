package com.example.yssyk_cool.controller;

import com.example.yssyk_cool.dto.location.request.LocationRequest;
import com.example.yssyk_cool.dto.location.response.LocationResponse;
import com.example.yssyk_cool.service.LocationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/location")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
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
