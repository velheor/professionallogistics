package com.velheor.internship.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

}
