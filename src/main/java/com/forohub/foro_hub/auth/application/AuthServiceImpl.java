package com.forohub.foro_hub.auth.application;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;


import com.forohub.foro_hub.auth.domain.dto.AuthResponse;
import com.forohub.foro_hub.auth.domain.dto.LoginRequest;
import com.forohub.foro_hub.auth.domain.dto.RegisterRequest;
import com.forohub.foro_hub.auth.security.jwt.JwtService;
import com.forohub.foro_hub.profiles.domain.entity.Profile;
import com.forohub.foro_hub.profiles.infrastructure.repository.ProfileRepository;
import com.forohub.foro_hub.users.domain.entity.User;
import com.forohub.foro_hub.users.infrastructure.repository.UserRepository;
import com.forohub.foro_hub.utils.exceptions.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository; 



    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {

        Optional<User> existingUser_name = userRepository.findByUsername(request.username());

        if (!existingUser_name.isPresent()) {
                throw new BusinessException("P-300", HttpStatus.CONFLICT, "The user doesn't exists");
            } 

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        UserDetails user=userRepository.findByUsername(request.username()).orElseThrow();
        String token = jwtService.getToken(user);

        // Fetch the user entity
        User userResponse = existingUser_name.get(); 


        return AuthResponse.builder()
                .token(token)
                .id(userResponse.getId()) 
                .username(userResponse.getUsername())
                .email(userResponse.getEmail())
                .build();
    }

    public AuthResponse register(RegisterRequest request) {

        Optional<User> existingUser_username = userRepository.findByUsername(request.username());

        if (existingUser_username.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "The username is already taken");
        } 

        if (userRepository.existsByEmail(request.email())) {
            throw new BusinessException("P-400", HttpStatus.CONFLICT, "The email already exists");
        }
        // Retrieve profile from the database
        Profile profile = profileRepository.findByName(request.profile())
        .orElseThrow(() -> new BusinessException("P-400", HttpStatus.NOT_FOUND, "Profile doesn't exist"));

        User user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode( request.password())) 
                .email(request.email())
                .profile(profile) 
                .enabled(true) 
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();

    }

}
