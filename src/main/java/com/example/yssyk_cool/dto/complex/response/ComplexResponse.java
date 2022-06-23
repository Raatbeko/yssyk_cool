package com.example.yssyk_cool.dto.complex.response;

import com.example.yssyk_cool.dto.contactInfo.response.ContactInfoResponse;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.dto.location.response.LocationResponse;
import com.example.yssyk_cool.entity.Location;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplexResponse {

    Long id;

    String name;

    List<FileResponse> fileResponses;

    LocationResponse locationResponse;

    ContactInfoResponse contactInfoResponse;

    String averagePrice;
}
