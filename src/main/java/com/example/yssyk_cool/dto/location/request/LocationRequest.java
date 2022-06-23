package com.example.yssyk_cool.dto.location.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationRequest {

    String country;

    String area;

    String streetName;

    String urlGoogleMap;
}
