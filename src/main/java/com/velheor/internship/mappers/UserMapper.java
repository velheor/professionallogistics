package com.velheor.internship.mappers;

import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.dto.UserWithRolesDTO;
import com.velheor.internship.models.Role;
import com.velheor.internship.models.User;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Named("rolesToListString")
    static List<String> rolesToListString(List<Role> roles) {
        return roles.stream()
            .map(role -> role.getName().toString())
            .collect(Collectors.toList());
    }

    UserViewDTO userToUserDto(User user);

    User userDtoToUser(UserViewDTO userViewDTO);

    @Mapping(target = "roles", qualifiedByName = "rolesToListString")
    UserWithRolesDTO userToUserWithRolesDto(User user);
}
