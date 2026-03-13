package com.template.spring.security.service;

import com.template.spring.security.application.dto.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TokenService {
    void validateAccessToken(String accessToken);

    void validateRefreshToken(String refreshToken);

    LoginResponse login(UUID userId);

    LoginResponse refresh(String refreshToken);

    String getSubjectFromAccessToken(String accessToken);
}
