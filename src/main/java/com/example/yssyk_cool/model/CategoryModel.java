package com.example.yssyk_cool.model;

import com.example.yssyk_cool.dto.complex.response.ComplexResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryModel {

    String cityName;

    List<ComplexResponse> complexResponses;
}
