package com.velheor.internship.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserViewDTO extends BaseDTO {

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

    public UserViewDTO(UserViewDTO userViewDTO) {
        super.setId(userViewDTO.getId());
        firstName = userViewDTO.getFirstName();
        lastName = userViewDTO.getLastName();
        email = userViewDTO.getEmail();
        phoneNumber = userViewDTO.getPhoneNumber();
        password = userViewDTO.getPassword();
    }
}
