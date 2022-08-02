package com.example.yssyk_cool.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends BaseException {
    public AlreadyExistsException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
