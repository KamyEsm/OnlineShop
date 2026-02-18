package org.example.onlineshop.Exception;

public class InsecurePassword extends RuntimeException {
    public InsecurePassword(String message) {
        super(message);
    }
}
