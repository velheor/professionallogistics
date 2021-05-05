package com.velheor.internship.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserWithRolesDTO extends UserViewDTO {

    private List<String> roles;
}
