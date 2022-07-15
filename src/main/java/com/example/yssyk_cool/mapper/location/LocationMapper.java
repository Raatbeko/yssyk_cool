package com.example.yssyk_cool.mapper.location;

import com.example.yssyk_cool.dto.location.response.LocationResponse;
import com.example.yssyk_cool.entity.Location;

import java.util.List;

public interface LocationMapper {

    LocationResponse toLocationResponse(Location location);

    List<LocationResponse> toListLocationResponse(List<Location> location);
}
