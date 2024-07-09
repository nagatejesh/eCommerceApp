package com.nbc.ecommerceApp.controller.advice;

import com.nbc.ecommerceApp.exception.ErrorResponse;
import com.nbc.ecommerceApp.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductsControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND,ex), HttpStatus.NOT_FOUND);
    }

}
