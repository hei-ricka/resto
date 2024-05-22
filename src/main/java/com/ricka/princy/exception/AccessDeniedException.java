package com.ricka.princy.exception;

import org.springframework.http.HttpStatus;

public class AccessDeniedException extends ApiException{
    public AccessDeniedException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }

    public AccessDeniedException(){
        super("Access denied", HttpStatus.FORBIDDEN);
    }
}
