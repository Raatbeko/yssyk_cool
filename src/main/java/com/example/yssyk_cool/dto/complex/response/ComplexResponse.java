package com.example.yssyk_cool.dto.complex.response;

import com.example.yssyk_cool.dto.contactInfo.response.ContactInfoResponse;
import com.example.yssyk_cool.dto.file.response.FileResponse;
import com.example.yssyk_cool.enums.TypeComplex;
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

    Long userId;

    String name;

    List<FileResponse> fileResponses;

    ContactInfoResponse contactInfoResponse;

    boolean deleted ;
}
