package com.velheor.internship.mappers;

import com.velheor.internship.dto.UserProfileUpdateDTO;
import com.velheor.internship.dto.UserRegistrationDTO;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract UserViewDTO toUserViewDto(User user);
    
    public abstract UserProfileUpdateDTO toUserProfileDto(User user);

    public abstract User userDtoToUser(UserViewDTO userViewDTO);

    public abstract User toUser(UserRegistrationDTO userRegistrationDTO);

    public abstract User toUser(UserProfileUpdateDTO userProfileUpdateDTO);

    public abstract Iterable<UserViewDTO> toUserViewDto(Iterable<User> users);

    public abstract Iterable<User> toUser(Iterable<UserViewDTO> usersViewDto);
}
