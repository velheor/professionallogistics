package com.velheor.internship.mappers;

import com.velheor.internship.dto.RoleViewDto;
import com.velheor.internship.models.Role;
import org.mapstruct.Mapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class RoleMapper {

    public List<GrantedAuthority> toGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().toString()))
                .collect(Collectors.toList());
    }

    public List<String> toRoles(Collection<? extends GrantedAuthority> userRoles) {
        return userRoles.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    public abstract RoleViewDto toRoleViewDto(Role role);

    public abstract Role toRole(RoleViewDto role);
}
