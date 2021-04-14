package com.velheor.internship.mappers;

import com.velheor.internship.dto.RoleDTO;
import com.velheor.internship.models.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleToRoleDto(Role role);

    Role roleDtoToRole(RoleDTO role);
}
