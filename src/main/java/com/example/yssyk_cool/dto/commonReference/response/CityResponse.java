package com.example.yssyk_cool.dto.commonReference.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityResponse {
    Long id;

    String title;

    Long typeCode;
}
