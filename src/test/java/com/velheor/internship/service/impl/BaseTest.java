package com.velheor.internship.service.impl;

import com.velheor.internship.models.Load;
import com.velheor.internship.models.Order;
import com.velheor.internship.models.Truck;
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

    static Truck truckExpected;
    static Truck truckTest;

    static Order orderExpected;
    static Order orderTest;

    static Load loadExpected;
    static Load loadTest;

    static {
        setUpUser();
        setUpTruckCategory();
        setUpTruck();
        setUpOrder();
        setUpLoad();
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

    static void setUpTruck() {
        truckExpected = new Truck();
        truckExpected.setId(UUID.fromString("a0a81b2e-9725-11eb-a8b3-0242ac130003"));
        truckExpected.setName("VOLVO");
        truckExpected.setRegistrationNumber("1234VA-5");
        truckExpected.setMaxWeight(new BigDecimal(10));
        truckExpected.setTruckCategory(truckCategoryTest);

        truckTest = new Truck();
        truckTest.setId(UUID.fromString("886c0c76-9727-11eb-a8b3-0242ac130003"));
        truckTest.setName("SCANIA");
        truckTest.setRegistrationNumber("2345AV-6");
        truckTest.setMaxWeight(new BigDecimal(11));
        truckTest.setTruckCategory(truckCategoryTest);
    }

    static void setUpOrder() {
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

    static void setUpLoad() {
        loadExpected = new Load();
        loadExpected.setId(UUID.fromString("5942070a-957b-11eb-a8b3-0242ac130003"));
        loadExpected.setName("FURNITURE");
        loadExpected.setWeight(new BigDecimal("0.5"));
        loadExpected.setDetails("Just furniture");
        loadExpected.setOrder(orderExpected);

        loadTest = new Load();
        loadTest.setId(UUID.fromString("60b523b4-957b-11eb-a8b3-0242ac130003"));
        loadTest.setName("BEER");
        loadTest.setWeight(new BigDecimal(23));
        loadTest.setDetails("HEINEKEN");
        loadTest.setOrder(orderTest);
    }

    public static void init() {
    }
}
