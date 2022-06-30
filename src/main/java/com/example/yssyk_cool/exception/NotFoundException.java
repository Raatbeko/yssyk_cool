package com.example.yssyk_cool.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public NotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
