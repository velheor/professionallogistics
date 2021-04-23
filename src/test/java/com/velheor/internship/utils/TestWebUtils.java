package com.velheor.internship.utils;

import static com.velheor.internship.utils.TestUtils.USER1;

import com.velheor.internship.dto.UserViewDTO;

public final class TestWebUtils {

    public static UserViewDTO USER_VIEW1 = new UserViewDTO();

    static {
        USER_VIEW1.setId(USER1.getId());
        USER_VIEW1.setFirstName(USER1.getFirstName());
        USER_VIEW1.setLastName(USER1.getLastName());
        USER_VIEW1.setEmail(USER1.getEmail());
        USER_VIEW1.setPhoneNumber(USER1.getPhoneNumber());
        USER_VIEW1.setPassword(USER1.getPassword());
    }
}
