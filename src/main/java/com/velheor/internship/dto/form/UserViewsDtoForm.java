package com.velheor.internship.dto.form;

import com.velheor.internship.dto.UserViewDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewsDtoForm {
    private Iterable<UserViewDTO> userViewDTOS;
}
