package com.nbc.ecommerceApp.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private String debugMessage;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private ErrorResponse(){
        this.timestamp = LocalDateTime.now();
    }
    public ErrorResponse(Throwable ex){
        this();
        this.message = "Unexpected error";
        this.debugMessage = ex.getMessage();
    }
    public ErrorResponse(String message, Throwable ex){
        this();
        this.message = message;
        this.debugMessage = ex.getMessage();
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
