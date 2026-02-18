package org.example.onlineshop.Exception;

public class DuplicateData extends RuntimeException {
    public DuplicateData(String message) {
        super(message);
    }
}
