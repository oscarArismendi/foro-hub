package com.forohub.foro_hub.auth.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record LoginRequest(

    @NotBlank(message = "Type the username")
    @Size(min = 4, max = 20, message = "min 4 and max 20 characters")
    String username,

    @NotBlank(message = "Type the password")
    @Size(min = 4, max = 255, message = "min 4 and max 255 characters")
    String password

) {

}
