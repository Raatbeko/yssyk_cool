package com.example.yssyk_cool.dto.user.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    @Email
    String email;

    String login;

    String password;

}
