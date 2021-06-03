package com.velheor.internship.dto.form;

import com.velheor.internship.dto.UserViewDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserViewDtoForm {
    private List<UserViewDto> userViewDtos;
}
