package com.forohub.foro_hub.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.forohub.foro_hub.auth.security.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors
                    .configurationSource(request -> {
                        var corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
                        corsConfiguration.addAllowedOrigin("http://localhost:8080");
                        corsConfiguration.addAllowedOrigin("http://localhost:3000");
                        corsConfiguration.addAllowedMethod("*");
                        corsConfiguration.addAllowedHeader("*");
                        corsConfiguration.setAllowCredentials(true);
                        return corsConfiguration;
                    })
                )
                .csrf(csrf -> csrf.disable()) //disable csrf for staless apps
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authz -> authz
                    .requestMatchers("/auth/**").permitAll() // allow all access to /auth/** 
                    .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                    .requestMatchers("/topics/**").authenticated() // Only authenticated users /**/** 
                    .anyRequest().authenticated()) // have to be an auth user for any other request
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
