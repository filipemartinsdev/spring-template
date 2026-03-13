package com.template.spring.security.application.dto;

public record LoginResponse (
        String accessToken,
        String refreshToken
) {

}
