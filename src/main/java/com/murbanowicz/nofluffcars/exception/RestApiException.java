package com.murbanowicz.nofluffcars.exception;

import org.springframework.http.HttpStatus;

public class RestApiException extends Exception{

    private final HttpStatus httpStatus;

    public RestApiException(HttpStatus httpStatus){
        super();
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}