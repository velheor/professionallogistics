package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthUserDTO {

    @NotNull(message = "{notEmpty}")
    private String email;

    @NotNull(message = "{notEmpty}")
    private String password;

    private String jwtToken;
}
