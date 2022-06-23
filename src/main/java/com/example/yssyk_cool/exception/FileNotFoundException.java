package com.example.yssyk_cool.exception;

import org.springframework.http.HttpStatus;

public class FileNotFoundException extends BaseException{

    public FileNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
