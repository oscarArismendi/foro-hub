package com.forohub.foro_hub.users.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
    @NotBlank String name,
    @NotBlank @Email String email,
    @NotBlank String password,
    Long profileId
) {}
