package org.example.onlineshop.Exception;

import lombok.Data;
import org.example.onlineshop.Enum.Status;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;          // Http Status name
    private String message;        // readable message
    private String path;           // request path
    private Status errorCode;   // custom error code
    private String traceId;        // for distributed tracing
    private List<FieldErrorDetail> fieldErrors; // validation errors

    public ErrorResponse(
            int status,
            String error,
            String message,
            String path,
            Status errorCode,
            String traceId,
            List<FieldErrorDetail> fieldErrors
    ) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
        this.traceId = traceId;
        this.fieldErrors = fieldErrors;
    }

}
