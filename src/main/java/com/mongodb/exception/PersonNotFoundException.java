package com.mongodb.exception;

import org.springframework.http.HttpStatus;

public class PersonNotFoundException extends RuntimeException{

    private HttpStatus httpStatus;
    public PersonNotFoundException() {
    }

    public PersonNotFoundException(String message) {
        super(message);
    }

    public PersonNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
