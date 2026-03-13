package com.template.spring.security.application.dto;

import java.time.Instant;

public record Token(
        String rawToken,
        Instant expiration,
        String subject
) {
}
