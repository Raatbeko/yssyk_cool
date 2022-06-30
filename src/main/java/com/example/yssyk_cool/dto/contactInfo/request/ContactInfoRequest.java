package com.example.yssyk_cool.dto.contactInfo.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactInfoRequest {

    Long complexId;

    String phoneNumber;

    String telegramAccountName;

    String email;


}
