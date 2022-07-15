package com.example.yssyk_cool.dto.file.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileComplexRequest {

    Long complexId;

    MultipartFile multipartFile;

}
