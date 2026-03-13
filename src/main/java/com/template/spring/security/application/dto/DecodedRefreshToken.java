package com.template.spring.security.application.dto;

import java.time.Instant;
import java.util.UUID;

public record DecodedRefreshToken(
        UUID tokenId,
        UUID userId,
        Instant expiration
) {}
