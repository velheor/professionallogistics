package com.velheor.internship.mappers;

import com.velheor.internship.dto.UserProfileUpdateDto;
import com.velheor.internship.dto.UserRegistrationDto;
import com.velheor.internship.dto.UserViewDto;
import com.velheor.internship.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract UserViewDto toUserViewDto(User user);

    public abstract UserProfileUpdateDto toUserProfileDto(User user);

    public abstract User toUser(UserViewDto userViewDTO);

    public abstract User toUser(UserRegistrationDto userRegistrationDTO);

    public abstract User toUser(UserProfileUpdateDto userProfileUpdateDTO);

    public abstract Iterable<UserViewDto> toUserViewDto(Iterable<User> users);

    public abstract Iterable<User> toUser(Iterable<UserViewDto> userViewDtos);
}
