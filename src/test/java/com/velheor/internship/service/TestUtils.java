package com.velheor.internship.service;

import com.velheor.internship.models.Address;
import com.velheor.internship.models.Load;
import com.velheor.internship.models.Order;
import com.velheor.internship.models.Role;
import com.velheor.internship.models.Status;
import com.velheor.internship.models.Truck;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import com.velheor.internship.models.enums.EStatus;
import com.velheor.internship.models.enums.ETruckCategory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public final class TestUtils {

    static Truck TRUCK1;
    static Truck TRUCK2;
    static String[] TRUCK_IGNORE;
    static Role ROLE1;
    static Role ROLE2;
    static String[] ROLE_IGNORE;
    static User USER1;
    static User USER2;
    static String[] USER_IGNORE;
    static Order ORDER1;
    static Order ORDER2;
    static String[] ORDER_IGNORE;
    static Load LOAD1;
    static Load LOAD2;
    static String[] LOAD_IGNORE;
    static Status STATUS1;
    static Status STATUS2;
    static String[] STATUS_IGNORE;
    static Address ADDRESS1;
    static Address ADDRESS2;
    static String[] ADDRESS_IGNORE;
    static Integer EXPECTED_SIZE = 1;

    static {
        setUpTruck();
        setUpUser();
        setUpRole();
        setUpOrder();
        setUpLoad();
        setUpStatus();
        setUpAddresses();
    }

    private TestUtils() {
    }

    static void setUpTruck() {
        TRUCK_IGNORE = new String[]{"user"};
        TRUCK1 = new Truck();
        TRUCK1.setId(UUID.fromString("2da16836-9c4a-11eb-a8b3-0242ac130003"));
        TRUCK1.setName("VOLVO");
        TRUCK1.setRegistrationNumber("1234VA-5");
        TRUCK1.setMaxWeight(new BigDecimal("4000.0"));
        TRUCK1.setTruckCategory(ETruckCategory.ALL_METAL);

        TRUCK2 = new Truck();
        TRUCK2.setId(UUID.fromString("365e1fdc-9c4a-11eb-a8b3-0242ac130003"));
        TRUCK2.setName("SCANIA");
        TRUCK2.setRegistrationNumber("2345AV-6");
        TRUCK2.setMaxWeight(new BigDecimal("3500.0"));
        TRUCK2.setTruckCategory(ETruckCategory.ALL_METAL);
    }

    static void setUpUser() {

        USER_IGNORE = new String[]{"carrierOrders", "shipperOrders", "roles",
            "truck"};

        USER1 = new User();
        USER1.setId(UUID.fromString("47a07384-93b8-11eb-a8b3-0242ac130003"));
        USER1.setFirstName("Ivan");
        USER1.setLastName("Ivanov");
        USER1.setEmail("ivan@gmail.com");
        USER1.setPhoneNumber("+375331234567");
        USER1.setPassword("pass1");

        USER2 = new User();
        USER2.setId(UUID.fromString("45caf4c2-9565-11eb-a8b3-0242ac130003"));
        USER2.setFirstName("Petr");
        USER2.setLastName("Petrov");
        USER2.setEmail("petr@gmail.com");
        USER2.setPhoneNumber("+375296888258");
        USER2.setPassword("pass2");
    }

    static void setUpRole() {
        ROLE_IGNORE = new String[]{"user"};

        ROLE1 = new Role();
        ROLE1.setId(UUID.fromString("cd2d4abe-9c4a-11eb-a8b3-0242ac130003"));
        ROLE1.setName(ERole.CARRIER);
        ROLE1.setUser(USER1);

        ROLE2 = new Role();
        ROLE2.setId(UUID.fromString("d2cba0ce-9c4a-11eb-a8b3-0242ac130003"));
        ROLE2.setName(ERole.SHIPPER);
        ROLE1.setUser(USER2);
    }

    static void setUpOrder() {
        ORDER_IGNORE = new String[]{"carrier", "shipper", "routes", "loads", "statuses"};

        ORDER1 = new Order();
        ORDER1.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        ORDER1.setDatePickup(LocalDateTime.of(2021, 1, 4, 11, 30));
        ORDER1.setDateDelivery(LocalDateTime.of(2021, 1, 10, 10, 0));
        ORDER1.setPrice(new BigDecimal("4000.0"));
        ORDER1.setTruckCategory(ETruckCategory.ALL_METAL);
        ORDER1.setCarrier(USER1);
        ORDER1.setShipper(USER2);

        ORDER2 = new Order();
        ORDER2.setId(UUID.fromString("3a424170-958b-11eb-a8b3-0242ac130003"));
        ORDER2.setDatePickup(LocalDateTime.of(2021, 2, 10, 11, 0));
        ORDER2.setDateDelivery(LocalDateTime.of(2021, 2, 12, 6, 0));
        ORDER2.setPrice(new BigDecimal("5000.0"));
        ORDER2.setTruckCategory(ETruckCategory.ALL_METAL);
    }

    static void setUpLoad() {
        LOAD_IGNORE = new String[]{"order"};

        LOAD1 = new Load();
        LOAD1.setId(UUID.fromString("5942070a-957b-11eb-a8b3-0242ac130003"));
        LOAD1.setName("FURNITURE");
        LOAD1.setWeight(new BigDecimal("0.5"));
        LOAD1.setDetails("Just furniture");
        LOAD1.setOrder(ORDER1);

        LOAD2 = new Load();
        LOAD2.setId(UUID.fromString("60b523b4-957b-11eb-a8b3-0242ac130003"));
        LOAD2.setName("BEER");
        LOAD2.setWeight(new BigDecimal("23.0"));
        LOAD2.setDetails("HEINEKEN");
    }

    static void setUpStatus() {
        STATUS_IGNORE = new String[]{"order"};

        STATUS1 = new Status();
        STATUS1.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        STATUS1.setName(EStatus.WAITING_FOR_CARRIER);
        STATUS1.setStatusDate(LocalDateTime.of(2021, 1, 3, 11, 30));
        STATUS1.setOrder(ORDER1);

        STATUS2 = new Status();
        STATUS2.setId(UUID.fromString("811f7588-96d8-11eb-a8b3-0242ac130003"));
        STATUS2.setName(EStatus.WAITING_FOR_LOADING);
        STATUS2.setStatusDate(LocalDateTime.of(2021, 1, 3, 11, 45));
        STATUS2.setOrder(ORDER2);
    }

    static void setUpAddresses() {
        ADDRESS_IGNORE = new String[]{"routeTo", "routeFrom"};
        ADDRESS1 = new Address();
        ADDRESS1.setId(UUID.fromString("fe8866ce-9c4b-11eb-a8b3-0242ac130003"));
        ADDRESS1.setCountry("BELARUS");
        ADDRESS1.setCity("HRODNO");
        ADDRESS1.setStreetName("STREET");
        ADDRESS1.setStreetNumber("1337-A");

        ADDRESS2 = new Address();
        ADDRESS2.setId(UUID.fromString("446d6234-9c4c-11eb-a8b3-0242ac130003"));
        ADDRESS2.setCountry("BELARUS");
        ADDRESS2.setCity("MINSK");
        ADDRESS2.setStreetName("STREETS");
        ADDRESS2.setStreetNumber("1373-B");
    }
}
