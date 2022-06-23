package com.example.yssyk_cool.exception;

import org.springframework.http.HttpStatus;

public class UserSignInException extends BaseException {
    public UserSignInException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
