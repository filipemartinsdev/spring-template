package com.template.spring.security.application.dto;

public record LoginRequest (
        String email,
        String password
) {
}
