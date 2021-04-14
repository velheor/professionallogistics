package com.velheor.internship.dto;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO {

    @NotNull(message = "{firstName.notEmpty}")
    private String firstName;

    @NotNull(message = "{lastName.notEmpty}")
    private String lastName;

    @NotNull(message = "{email.notEmpty}")
    @Email(message = "{email.validation}")
    private String email;

    @NotNull(message = "{phoneNumber.notEmpty}")
    private String phoneNumber;

    private List<RoleDTO> roles;
}
