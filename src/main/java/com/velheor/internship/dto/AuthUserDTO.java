package com.velheor.internship.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AuthUserDTO {

    @Email(message = "{notValidEmail}")
    @Size(max = 255, message = "{notCorrectSize}")
    @NotEmpty(message = "{notEmpty}")
    private String email;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 7, max = 255, message = "{notCorrectSize}")
    private String password;

    public AuthUserDTO(AuthUserDTO authUserDTO) {
        this.email = authUserDTO.getEmail();
        this.password = authUserDTO.getPassword();
    }
}
