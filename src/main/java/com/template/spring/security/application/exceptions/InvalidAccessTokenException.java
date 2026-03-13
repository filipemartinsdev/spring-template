package com.template.spring.security.application.exceptions;

public class InvalidAccessTokenException extends RuntimeException {
    public InvalidAccessTokenException() {
        super("Invalid access token");
    }

    public InvalidAccessTokenException(String message) {
        super(message);
    }
}
