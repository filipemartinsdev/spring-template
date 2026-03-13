package com.template.spring.security.application.exceptions;

public class UsernameOrEmailAlreadyExistsException extends RuntimeException{
    public UsernameOrEmailAlreadyExistsException(String message) {
        super(message);
    }

    public UsernameOrEmailAlreadyExistsException() {
        super("Username or Email already exists");
    }
}
