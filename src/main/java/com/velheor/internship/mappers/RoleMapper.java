package com.velheor.internship.mappers;

import com.velheor.internship.dto.RoleViewDTO;
import com.velheor.internship.models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().toString()))
                .collect(Collectors.toList());
    }

    @Named("rolesToListString")
    static List<String> rolesToListString(List<Role> roles) {
        return roles.stream()
                .map(role -> role.getName().toString())
                .collect(Collectors.toList());
    }

    RoleViewDTO roleToRoleDto(Role role);

    Role roleDtoToRole(RoleViewDTO role);
}
