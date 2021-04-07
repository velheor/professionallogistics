package com.velheor.internship.service.impl;

import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import java.util.UUID;

public class BaseTest {

    public static User userExpected;
    public static User userTest;

    static {
        setUpUser();
    }

    public static void setUpUser() {
        userExpected = new User();
        userExpected.setId(UUID.fromString("47a07384-93b8-11eb-a8b3-0242ac130003"));
        userExpected.setFirstName("Ivan");
        userExpected.setLastName("Ivanov");
        userExpected.setEmail("ivan@gmail.com");
        userExpected.setPhoneNumber("+375331234567");
        userExpected.setPassword("pass1");
        userExpected.setRole(ERole.CARRIER);

        userTest = new User();
        userTest.setId(UUID.fromString("45caf4c2-9565-11eb-a8b3-0242ac130003"));
        userTest.setFirstName("Petr");
        userTest.setLastName("Petrov");
        userTest.setEmail("petr@gmail.com");
        userTest.setPhoneNumber("+375296888258");
        userTest.setPassword("pass2");
        userTest.setRole(ERole.CARRIER);
    }

    public static void init() {
    }
}
