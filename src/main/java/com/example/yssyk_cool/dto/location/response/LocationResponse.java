package com.example.yssyk_cool.dto.location.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationResponse {

    Long id;

    String country;

    String areaId;

    String streetName;

    String urlGoogleMap;
}
