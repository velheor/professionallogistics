package com.velheor.internship.mappers;

import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserViewDTO userToUserDto(User user);

    User userDtoToUser(UserViewDTO userViewDTO);
}
