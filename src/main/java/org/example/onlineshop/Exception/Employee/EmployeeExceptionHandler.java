package org.example.onlineshop.Exception.Employee;

import jakarta.servlet.http.HttpServletRequest;
import org.example.onlineshop.Enum.Status;
import org.example.onlineshop.Exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> HandleUserNotFoundException(UserNotFoundException ex, HttpServletRequest request) {
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
    public ResponseEntity<?> HandleFailRegister(EmployeeNotCreated ex, HttpServletRequest request) {
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
    public ResponseEntity<?> HandleDuplicateUsername(DuplicateUsername ex, HttpServletRequest request) {
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


