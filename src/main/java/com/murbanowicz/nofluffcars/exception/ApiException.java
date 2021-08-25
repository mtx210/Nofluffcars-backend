package com.murbanowicz.nofluffcars.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception{

    private final HttpStatus httpStatus;

    public ApiException(HttpStatus httpStatus){
        super();
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}