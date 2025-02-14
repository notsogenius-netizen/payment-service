package com.sourabh.payment_service.exception;

import org.springframework.http.HttpStatus;

public class AmountMismatchException extends RuntimeException{
    private HttpStatus statusCode;
    public AmountMismatchException(String message, HttpStatus statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}
