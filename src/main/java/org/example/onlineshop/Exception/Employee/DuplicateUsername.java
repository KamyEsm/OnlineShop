package org.example.onlineshop.Exception.Employee;

public class DuplicateUsername extends RuntimeException {
    public DuplicateUsername(String message) {
        super(message);
    }
}
