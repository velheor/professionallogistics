package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AuthUserDTO {

    @Email(message = "{notValidEmail}")
    @Size(max = 255, message = "{notCorrectSize}")
    @NotEmpty(message = "{notEmpty}")
    private String email;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 7, max = 255, message = "{notCorrectSize}")
    private String password;
}
