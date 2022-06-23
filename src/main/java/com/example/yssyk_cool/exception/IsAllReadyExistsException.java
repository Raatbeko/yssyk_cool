package com.example.yssyk_cool.exception;

import org.springframework.http.HttpStatus;

public class IsAllReadyExistsException extends BaseException {


    public IsAllReadyExistsException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
