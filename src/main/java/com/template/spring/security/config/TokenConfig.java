package com.template.spring.security.config;

import com.template.spring.security.infra.persistence.RefreshTokenRepository;
import com.template.spring.security.service.JWTService;
import com.template.spring.security.service.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {
    @Bean
    public TokenService tokenService(RefreshTokenRepository refreshTokenRepository) {
        return new JWTService(refreshTokenRepository);
    }
}
