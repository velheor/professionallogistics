package com.velheor.internship.dto;

import java.util.List;
import lombok.Data;

@Data
public class UserWithRolesDTO extends UserViewDTO {

    private List<String> roles;
}
