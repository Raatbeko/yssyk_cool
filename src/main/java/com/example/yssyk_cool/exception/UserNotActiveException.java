package com.example.yssyk_cool.exception;

import org.springframework.http.HttpStatus;

public class UserNotActiveException extends BaseException {

    public UserNotActiveException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
