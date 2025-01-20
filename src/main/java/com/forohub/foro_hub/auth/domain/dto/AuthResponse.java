package com.forohub.foro_hub.auth.domain.dto;

import lombok.Builder;

@Builder
public record AuthResponse(

    String token,
    Long id,      
    String username,
    String email
) {

}
