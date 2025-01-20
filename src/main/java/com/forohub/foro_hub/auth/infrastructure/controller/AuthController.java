package com.forohub.foro_hub.auth.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forohub.foro_hub.auth.application.AuthServiceImpl;
import com.forohub.foro_hub.auth.domain.dto.AuthResponse;
import com.forohub.foro_hub.auth.domain.dto.LoginRequest;
import com.forohub.foro_hub.auth.domain.dto.RegisterRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authAdapter;

     
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(authAdapter.login(request));
    }

    @Operation(
            summary = "Login User",
            description = "Authenticate a user and return the authentication token along with user details.",

            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Authentication request with username and password",
                    required = true,
                    content = @Content(
                        mediaType = "application/json",
                        examples = {
                            @ExampleObject(
                                value = """
                                {
                                    "username": "Sample User",
                                    "password": "123Abc#",
                                    "email": "sample@example.com",
                                    "profile": "administrator"
                                }
                                """
                            )
                        }
                    )
            )
    )
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authAdapter.register(request));
    }

    @GetMapping("/test")
    public String demo() {
        return "It's working";
    }
    
}