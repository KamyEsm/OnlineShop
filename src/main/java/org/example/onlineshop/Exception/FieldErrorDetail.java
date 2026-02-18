package org.example.onlineshop.Exception;

import lombok.Data;

@Data
public class FieldErrorDetail {

    private String field;
    private String message;

    public FieldErrorDetail(String field, String message) {
        this.field = field;
        this.message = message;
    }

}
