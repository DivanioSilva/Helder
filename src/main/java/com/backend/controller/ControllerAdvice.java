package com.backend.controller;

import com.backend.exceptions.ErrorMessage;
import com.backend.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { UserNotFoundException.class})
    protected ErrorMessage handleConflict(
            UserNotFoundException ex) {
        return ErrorMessage
                .builder()
                .message(ex.getMessage())
                .build();
    }
}
