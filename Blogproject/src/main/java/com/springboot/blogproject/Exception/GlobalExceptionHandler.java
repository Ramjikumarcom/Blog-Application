package com.springboot.blogproject.Exception;

import com.springboot.blogproject.Payload.Apiresponse;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Apiresponse> ResourceNotFoundException(UserNotFoundException ex) {
        String message = ex.getMessage();
        return new ResponseEntity<Apiresponse>(new Apiresponse(message, false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> resp = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField(); // Get the field name
            String message = error.getDefaultMessage(); // Get the error message
            resp.put(fieldName, message); // Add to the response map
        });

        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

}
