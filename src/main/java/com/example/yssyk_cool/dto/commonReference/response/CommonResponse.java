package com.example.yssyk_cool.dto.commonReference.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonResponse {
    Long id;

    String title;

    Long typeCode;
}
