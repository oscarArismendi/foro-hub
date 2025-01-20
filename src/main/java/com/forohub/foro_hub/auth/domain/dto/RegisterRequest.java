package com.forohub.foro_hub.auth.domain.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RegisterRequest(

    @NotBlank(message = "The username can't be empty")
    @Size(min = 4, max = 20, message = "The username must have minimum 4 and maximum 20 characters")
    String username,

    @NotBlank(message = "You need a password")
    @Size(min = 4, max = 255, message = "The username must have minimum 4 and maximum 255 characters")
    String password,

    @NotBlank(message = "Please add a email")
    @Size(min = 4, max = 255, message = "The username must have minimum 4 and maximum 255 characters")
    @Email(message = "The email must be in this format: johndoe@gmail.com")
    String email,

    @NotBlank(message = "Please add a role")
    String  profile
) {

}
