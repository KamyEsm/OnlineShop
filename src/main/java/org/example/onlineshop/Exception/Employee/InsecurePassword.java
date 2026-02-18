package org.example.onlineshop.Exception.Employee;

public class InsecurePassword extends RuntimeException {
    public InsecurePassword(String message) {
        super(message);
    }
}
