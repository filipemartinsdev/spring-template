package com.template.spring.security.application.exceptions;

public class RefreshTokenNotFoundException extends RuntimeException {
    public RefreshTokenNotFoundException() {
        super("Refresh token not found");
    }

    public RefreshTokenNotFoundException(String message) {
        super(message);
    }
}
