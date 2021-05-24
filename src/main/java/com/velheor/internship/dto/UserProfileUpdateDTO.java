package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserProfileUpdateDTO {

    @Size(min = 2, max = 15, message = "{notCorrectSize}")
    private String firstName;

    @Size(min = 2, max = 15, message = "{notCorrectSize}")
    private String lastName;

    @Email(message = "{notValidEmail}")
    @Size(max = 255, message = "{notCorrectSize}")
    private String email;

    @Pattern(regexp = "^\\+375 \\((17|29|33|44)\\) [0-9]{3}-[0-9]{2}-[0-9]{2}$", message = "{notValidPhoneNumber}")
    private String phoneNumber;

    @Size(min = 7, max = 255, message = "{notCorrectSize}")
    private String password;
}
