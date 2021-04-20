package com.velheor.internship.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserViewDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    @Size(min = 2, max = 15, message = "{notCorrectSize}")
    private String firstName;

    @NotNull(message = "{notEmpty}")
    @Size(min = 2, max = 15, message = "{notCorrectSize}")
    private String lastName;

    @NotNull(message = "{notEmpty}")
    @Email(message = "{notValidEmail}")
    @Size(max = 255, message = "{notCorrectSize}")
    private String email;

    @NotNull(message = "{notEmpty}")
    @Size(min = 19, max = 19, message = "{notCorrectSize}")
    @Pattern(regexp = "^\\+375 \\((17|29|33|44)\\) [0-9]{3}-[0-9]{2}-[0-9]{2}$", message = "{notValidPhoneNumber}")
    private String phoneNumber;

    @NotNull(message = "{notEmpty}")
    @Size(min = 7, max = 255, message = "{notCorrectSize}")
    private String password;

}
