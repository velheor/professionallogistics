package com.velheor.internship.dto;

import com.velheor.internship.models.Role;
import java.util.List;
import lombok.Data;

@Data
public class UserWithRolesDTO extends UserViewDTO {

    private List<Role> roles;
}
