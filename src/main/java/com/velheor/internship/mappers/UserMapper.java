package com.velheor.internship.mappers;

import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.models.Role;
import com.velheor.internship.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

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

    Iterable<UserViewDTO> usersToUsersDto(Iterable<User> users);
}
