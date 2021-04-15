package com.velheor.internship.dto;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {

    @NotNull(message = "notEmpty")
    @Size(min = 2, max = 12, message = "notCorrectSize}")
    private String firstName;

    @NotNull(message = "notEmpty")
    @Size(min = 2, max = 12, message = "notCorrectSize")
    private String lastName;

    @NotNull(message = "notEmpty")
    @Email
    private String email;

    @NotNull(message = "notEmpty")
    @Size(min = 12, max = 12, message = "notCorrectSize")
    @Pattern(regexp = "(8 0(25|29|33|34) ([0-9]{3}( [0-9]{2}){2}))")
    private String phoneNumber;

    private List<RoleDTO> roles;
}
