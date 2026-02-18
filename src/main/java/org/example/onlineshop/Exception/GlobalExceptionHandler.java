package org.example.onlineshop.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.example.onlineshop.Enum.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {

        List<FieldErrorDetail> fieldErrors = new ArrayList<>();

        for (FieldError error : ex.getFieldErrors()) {
            FieldErrorDetail fieldErrorDetail = new FieldErrorDetail(error.getField(), error.getDefaultMessage());
            fieldErrors.add(fieldErrorDetail);
        }

        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI(),
                Status.VALIDATION_ERROR,
                getTraceId(),
                fieldErrors
        );

        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler
    public ResponseEntity<?> HandleNotFoundException(NotFound ex, HttpServletRequest request) {
            ErrorResponse response = new ErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ex.getMessage(),
                    request.getRequestURI(),
                    Status.RESOURCE_NOT_FOUND,
                    getTraceId(),
                    null
            );

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler
    public ResponseEntity<?> HandleFailRegister(NotCreated ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI(),
                Status.Failed_Registration,
                getTraceId(),
                null
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler
    public ResponseEntity<?> HandleDuplicateData(DuplicateData ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI(),
                Status.UserNameAlreadyExists,
                getTraceId(),
                null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


    @ExceptionHandler
    public ResponseEntity<?> HandleInsecurePassword(InsecurePassword ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI(),
                Status.InsecurePassword,
                getTraceId(),
                null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    private String getTraceId() {
        return UUID.randomUUID().toString();
    }


}


