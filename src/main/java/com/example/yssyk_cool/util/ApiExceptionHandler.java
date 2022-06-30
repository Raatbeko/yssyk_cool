package com.example.yssyk_cool.util;

import com.example.yssyk_cool.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    @ExceptionHandler(value = {
            Exception.class
    })
    public ResponseEntity<ResponseMessageModel<String>> handleFailException(BaseException baseException) {
        ResponseMessageModel<String> exceptionResponseMessageModel = new ResponseMessageModel<>();
        exceptionResponseMessageModel.setMessage(baseException.getMessage());
        String threwClassName = baseException.getStackTrace()[0].getClassName();
        log.warn(threwClassName + " : " + baseException.getMessage());
        return new ResponseEntity<>(exceptionResponseMessageModel, baseException.getHttpStatus());
    }
}
