package com.example.yssyk_cool.util;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseMessageModel<T> {
    T value;
    String message;

    public ResponseMessageModel<T> prepareSuccessMessage(T value) {
        return ResponseMessageModel.<T>builder()
                .value(value)
                .message(null)
                .build();
    }

    public ResponseMessageModel<T> prepareFailMessage(String message) {
        return ResponseMessageModel.<T>builder()
                .value(null)
                .message(message)
                .build();
    }
}
