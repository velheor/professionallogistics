package com.velheor.internship.mappers;

import com.velheor.internship.dto.UserProfileUpdateDTO;
import com.velheor.internship.dto.UserRegistrationDTO;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract UserViewDTO userToUserDto(User user);

    public abstract User userDtoToUser(UserViewDTO userViewDTO);

    public abstract User userRegistrationDtoToUser(UserRegistrationDTO userRegistrationDTO);

    public abstract User userUpdateProfileDtoToUser(UserProfileUpdateDTO userProfileUpdateDTO);

    public abstract Iterable<UserViewDTO> usersToUsersDto(Iterable<User> users);

    public abstract Iterable<User> usersDtoToUser(Iterable<UserViewDTO> usersViewDto);
}
