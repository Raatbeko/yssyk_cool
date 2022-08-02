package com.example.yssyk_cool.dto.complex.request;

import com.example.yssyk_cool.dto.contactInfo.request.ContactInfoRequest;
import com.example.yssyk_cool.dto.location.request.LocationRequest;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplexRequest {

    Long createdById;

    @NotNull
    String nameComplex;

    String aboutComplex;

    String averagePrice;

    String typeComplex;

    LocationRequest locationRequest;

    ContactInfoRequest contactInfoRequest;

}
