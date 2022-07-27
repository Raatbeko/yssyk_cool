package com.example.yssyk_cool.dto.complex.request;

import com.example.yssyk_cool.dto.contactInfo.request.ContactInfoForUpdateRequest;
import com.example.yssyk_cool.enums.TypeComplex;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComplexForUpdateRequest {

    Long complexId;

    @NotNull
    String nameComplex;

    String aboutComplex;

    String averagePrice;

    ContactInfoForUpdateRequest contactInfoRequest;
}
