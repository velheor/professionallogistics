package com.velheor.internship.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserProfileUpdateDTO {

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 15, message = "{notCorrectSize}")
    private String firstName;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 15, message = "{notCorrectSize}")
    private String lastName;

    @NotEmpty(message = "{notEmpty}")
    @Email(message = "{notValidEmail}")
    @Size(max = 255, message = "{notCorrectSize}")
    private String email;

    @NotEmpty(message = "{notEmpty}")
    @Pattern(regexp = "^\\+375 \\((17|29|33|44)\\) [0-9]{3}-[0-9]{2}-[0-9]{2}$", message = "{notValidPhoneNumber}")
    private String phoneNumber;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 7, max = 255, message = "{notCorrectSize}")
    private String password;
}
