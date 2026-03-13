package com.template.spring.user.application.mappers;

import com.template.spring.user.domain.UserProfile;
import com.template.spring.user.application.dto.UserProfileResponse;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper {
    public UserProfileResponse toResponse(UserProfile userProfile) {
        return new UserProfileResponse(
                userProfile.getUserId(),
                userProfile.getUsername()
        );
    }
}
