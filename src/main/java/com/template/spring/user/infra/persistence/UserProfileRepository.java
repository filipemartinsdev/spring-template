package com.template.spring.user.infra.persistence;

import com.template.spring.user.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
    List<UserProfile> findByUsername(String username);
}
