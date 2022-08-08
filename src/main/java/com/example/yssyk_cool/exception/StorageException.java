package com.example.yssyk_cool.exception;

import org.springframework.http.HttpStatus;

import java.net.MalformedURLException;

public class StorageException extends BaseException {

    public StorageException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
