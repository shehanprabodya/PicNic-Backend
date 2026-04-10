package com.picnic.backend.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthReqest {

    @Email(message="email is not valid")
    @NotBlank(message = "user email is required ")
    private String email;

    @NotBlank(message = "password is required")
    private String password;
}
