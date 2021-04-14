package com.velheor.internship.mappers;

import com.velheor.internship.dto.UserDTO;
import com.velheor.internship.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDto(User user);

    User userDtoToUser(UserDTO userDTO);
}
