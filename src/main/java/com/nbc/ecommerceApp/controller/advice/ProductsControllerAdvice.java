package com.nbc.ecommerceApp.controller.advice;

import com.nbc.ecommerceApp.exception.ErrorResponse;
import com.nbc.ecommerceApp.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductsControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFoundException(ProductNotFoundException ex){
        ErrorResponse response = new ErrorResponse(ex);
        return response;
    }

}
