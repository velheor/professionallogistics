package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthUserDTO {

    @NotNull(message = "{notEmpty}")
    private String email;

    @NotNull(message = "{notEmpty}")
    private String password;

    private String jwtToken;
}
