package com.nbc.ecommerceApp.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private String debugMessage;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private HttpStatus status;

    private ErrorResponse(){
        this.timestamp = LocalDateTime.now();
    }
    public ErrorResponse(HttpStatus status, Throwable ex){
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getMessage();
    }
    public ErrorResponse(HttpStatus status, String message, Throwable ex){
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getMessage();
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                ", timestamp=" + timestamp +
                ", status=" + status +
                '}';
    }
}
