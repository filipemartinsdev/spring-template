package com.template.spring.security.application.dto;

import java.util.UUID;

public record UserCredentialsResponse(
        UUID userId,
        String username,
        String email
) {
}
