package org.example.onlineshop.Exception.Role;

import jakarta.servlet.http.HttpServletRequest;
import org.example.onlineshop.Enum.Status;
import org.example.onlineshop.Exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class RoleExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> NotFountHandler(RoleNotFound ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI(),
                Status.Not_Found,
                getTraceId(),
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    private String getTraceId() {
        return UUID.randomUUID().toString();
    }
}
