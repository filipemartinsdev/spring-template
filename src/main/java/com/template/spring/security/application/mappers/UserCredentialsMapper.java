package com.template.spring.security.application.mappers;

import com.template.spring.security.application.dto.UserCredentialsResponse;
import com.template.spring.security.domain.UserCredentials;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialsMapper {
    public UserCredentialsResponse toResponse(UserCredentials userCredentials) {
        return new UserCredentialsResponse(
                userCredentials.getId(),
                userCredentials.getUsername(),
                userCredentials.getEmail()
        );
    }
}
