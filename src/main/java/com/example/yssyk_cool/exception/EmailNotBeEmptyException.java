package com.example.yssyk_cool.exception;


import org.springframework.http.HttpStatus;

public class EmailNotBeEmptyException extends BaseException {

    public EmailNotBeEmptyException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
