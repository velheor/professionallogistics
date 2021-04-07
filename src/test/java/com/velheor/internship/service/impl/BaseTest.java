package com.velheor.internship.service.impl;

import com.velheor.internship.models.Order;
import com.velheor.internship.models.TruckCategory;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BaseTest {

    static User userExpected;
    static User userTest;

    static TruckCategory truckCategoryExpected;
    static TruckCategory truckCategoryTest;

    static Order orderExpected;
    static Order orderTest;

    static {
        setUpUser();
        setUpTruckCategory();
        setUpOrder();
    }

    static void setUpUser() {
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

    static void setUpTruckCategory() {
        truckCategoryExpected = new TruckCategory();
        truckCategoryExpected.setId(0);
        truckCategoryExpected.setName("COVERED");

        truckCategoryTest = new TruckCategory();
        truckCategoryTest.setId(1);
        truckCategoryTest.setName("ALL-METAL");
        truckCategoryTest.setTruckCategory(truckCategoryExpected);
    }

    static void setUpOrder(){
        orderExpected = new Order();
        orderExpected.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        orderExpected.setDatePickup(LocalDateTime.of(2021, 1, 3, 11, 30));
        orderExpected.setDateDelivery(LocalDateTime.of(2021, 1, 10, 10, 0));
        orderExpected.setPrice(new BigDecimal(4000));

        orderTest = new Order();
        orderTest.setId(UUID.fromString("3a424170-958b-11eb-a8b3-0242ac130003"));
        orderTest.setDateDelivery(LocalDateTime.of(2021, 2, 10, 12, 0));
        orderTest.setDatePickup(LocalDateTime.of(2021, 2, 12, 6, 0));
        orderTest.setPrice(new BigDecimal(5000));
    }

    public static void init() {
    }
}
