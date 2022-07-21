package com.example.yssyk_cool.dto.contactInfo.request;

import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactInfoForUpdateRequest {

    Long contactInfoId;

    String phoneNumber;

    String telegramAccountName;

    String email;
}
