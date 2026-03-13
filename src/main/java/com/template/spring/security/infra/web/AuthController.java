package com.template.spring.security.infra.web;

import br.social.impacthub.model.dto.*;
import com.spring.template.model.dto.*;
import com.template.spring.application.dto.StandardResponse;
import com.template.spring.security.application.dto.LoginRequest;
import com.template.spring.security.application.dto.LoginResponse;
import com.template.spring.security.application.dto.RefreshRequest;
import com.template.spring.security.application.dto.RegisterUserRequest;
import com.template.spring.security.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterUserRequest request) {
        authService.register(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/login")
    public ResponseEntity<StandardResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(StandardResponse.success(response));
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody RefreshRequest request) {
        LoginResponse response = authService.refresh(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}