package com.template.spring.application.exceptions;

public class UserNotAuthenticatedException extends RuntimeException {
    public UserNotAuthenticatedException(String message) {
        super(message);
    }

    public UserNotAuthenticatedException() {
        super("User is not authenticated");
    }
}
