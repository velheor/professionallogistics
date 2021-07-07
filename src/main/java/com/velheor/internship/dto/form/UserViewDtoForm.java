package com.velheor.internship.dto.form;

import com.velheor.internship.dto.UserViewDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
public class UserViewDtoForm {
    private List<@Valid UserViewDto> userViewDtos;
}
