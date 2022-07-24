package com.example.yssyk_cool.dto.user.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserTokenResponse {

    Long userId;
    
    String userToken;
}
