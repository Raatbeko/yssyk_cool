package com.example.yssyk_cool.dto.contactInfo.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactInfoResponse {

    Long  id;

    String phoneNumber;

    String telegramAccountName;

    String email;
}
