package com.example.yssyk_cool.dto.user.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAuthRequest {
    String loginOrEmail;

    String password;
}

