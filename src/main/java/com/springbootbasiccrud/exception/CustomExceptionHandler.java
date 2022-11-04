package com.springbootbasiccrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotNullException.class)
    public ResponseEntity<?> userNotNull(UserNotNullException userNotNullException){
        List<String> detail = new ArrayList<>();
        detail.add(userNotNullException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Not Null User",detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
