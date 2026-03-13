package com.template.spring.security.application.exceptions;

public class InvalidRefreshTokenException extends RuntimeException {
    public InvalidRefreshTokenException() {
        super("Invalid refresh token");
    }

    public InvalidRefreshTokenException(String message) {
        super(message);
    }
}
