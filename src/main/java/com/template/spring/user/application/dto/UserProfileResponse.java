package com.template.spring.user.application.dto;

import java.util.UUID;

public record UserProfileResponse(
        UUID userId,
        String username
) {
}
