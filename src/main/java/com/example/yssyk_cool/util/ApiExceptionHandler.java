package com.example.yssyk_cool.util;

import com.example.yssyk_cool.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    @ExceptionHandler(value = {
            EmailNotBeEmptyException.class,
            FileNotFoundException.class,
            IsAllReadyExistsException.class,
            NotFoundException.class,
            StorageException.class,
            UserNotActiveException.class,
            UserSignInException.class,
            RuntimeException.class
    })
    public ResponseEntity<String> handleFailException(BaseException baseException) {
        String massage;
        massage = baseException.getMessage();
        return new ResponseEntity<>(massage , baseException.getHttpStatus());
    }
}
