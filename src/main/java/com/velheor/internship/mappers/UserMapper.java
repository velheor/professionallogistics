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

    UserViewDTO userToUserDto(User user);

    User userDtoToUser(UserViewDTO userViewDTO);

    Iterable<UserViewDTO> usersToUsersDto(Iterable<User> users);
}
