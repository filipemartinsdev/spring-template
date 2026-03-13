package com.template.spring.security.service;

import com.template.spring.security.application.exceptions.InvalidAccessTokenException;
import com.template.spring.application.exceptions.UserNotAuthenticatedException;
import com.template.spring.security.application.dto.LoginRequest;
import com.template.spring.security.application.dto.LoginResponse;
import com.template.spring.security.application.dto.RefreshRequest;
import com.template.spring.security.application.dto.RegisterUserRequest;
import com.template.spring.security.application.dto.AuthenticatedUser;
import com.template.spring.security.domain.UserCredentials;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {
    private UserCredentialsService userCredentialsService;
    private TokenService tokenService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public AuthService(UserCredentialsService userCredentialsService, TokenService tokenService, PasswordEncoder passwordEncoder, @Lazy AuthenticationManager authenticationManager) {
        this.userCredentialsService = userCredentialsService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    public void register(@Valid RegisterUserRequest request){
        String encryptedPassword = passwordEncoder.encode(request.password());
        userCredentialsService.create(request.username(), request.email(), encryptedPassword);
    }

    @Transactional
    public LoginResponse login(LoginRequest request){
        Authentication auth = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        authenticationManager.authenticate(auth);

        UUID userId = userCredentialsService.getByEmail(request.email()).userId();
        return tokenService.login(userId);
    }

    @Transactional
    public LoginResponse refresh(RefreshRequest request){
        return tokenService.refresh(request.refreshToken());
    }

    public AuthenticatedUser getAuthenticatedUser(){
        try {
            UserCredentials userCredentials = (UserCredentials) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return new AuthenticatedUser(
                    userCredentials.getId(),
                    userCredentials.getUsername(),
                    userCredentials.getEmail()
            );
        } catch (Exception e){
            throw new UserNotAuthenticatedException();
        }
    }

    public void validateAccessToken(String accessToken){
        tokenService.validateAccessToken(accessToken);
    }

    public UUID getUserId(String accessToken){
        try {
            return UUID.fromString(
                    tokenService.getSubjectFromAccessToken(accessToken)
            );
        } catch (RuntimeException e){
            throw new InvalidAccessTokenException();
        }
    }
}
