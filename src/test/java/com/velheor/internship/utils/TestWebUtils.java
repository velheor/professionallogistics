package com.velheor.internship.utils;

import static com.velheor.internship.utils.TestUtils.USER1;
import static com.velheor.internship.utils.TestUtils.USER2;

import com.velheor.internship.dto.UserViewDTO;

public final class TestWebUtils {

    public final static UserViewDTO USER_VIEW_DTO1 = new UserViewDTO();
    public final static UserViewDTO USER_VIEW_DTO2 = new UserViewDTO();

    static {
        USER_VIEW_DTO1.setId(USER1.getId());
        USER_VIEW_DTO1.setFirstName(USER1.getFirstName());
        USER_VIEW_DTO1.setLastName(USER1.getLastName());
        USER_VIEW_DTO1.setEmail(USER1.getEmail());
        USER_VIEW_DTO1.setPhoneNumber(USER1.getPhoneNumber());
        USER_VIEW_DTO1.setPassword(USER1.getPassword());

        USER_VIEW_DTO2.setId(USER2.getId());
        USER_VIEW_DTO2.setFirstName(USER2.getFirstName());
        USER_VIEW_DTO2.setLastName(USER2.getLastName());
        USER_VIEW_DTO2.setEmail(USER2.getEmail());
        USER_VIEW_DTO2.setPhoneNumber(USER2.getPhoneNumber());
        USER_VIEW_DTO2.setPassword(USER2.getPassword());
    }
}
