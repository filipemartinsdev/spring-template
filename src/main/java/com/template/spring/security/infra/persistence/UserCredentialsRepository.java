package com.template.spring.security.infra.persistence;

import com.template.spring.security.domain.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, UUID> {
    Optional<UserCredentials> findByUsername(String username);

    Optional<UserCredentials> findByEmail(String email);
}
