package com.velheor.internship.dto;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    private String firstName;

    @NotNull(message = "{notEmpty}")
    private String lastName;

    @NotNull(message = "{notEmpty}")
    @Email(message = "{validation}")
    private String email;

    @NotNull(message = "{notEmpty}")
    private String phoneNumber;

    private List<RoleDTO> roles;
}
