package com.template.spring.user.service;

import com.template.spring.user.domain.UserProfile;
import com.template.spring.user.infra.persistence.UserProfileRepository;
import com.template.spring.user.application.dto.UserProfileResponse;
import com.template.spring.user.application.mappers.UserProfileMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserProfileService {
    private UserProfileRepository userProfileRepository;
    private UserProfileMapper userProfileMapper;

    public UserProfileService(UserProfileRepository userProfileRepository, UserProfileMapper userProfileMapper) {
        this.userProfileRepository = userProfileRepository;
        this.userProfileMapper = userProfileMapper;
    }

    public UserProfileResponse create(UUID userId, String username){
        return userProfileMapper.toResponse(
                userProfileRepository.save(
                        new UserProfile(
                                userId,
                                username,
                                ""
                        )
                )
        );
    }
}
