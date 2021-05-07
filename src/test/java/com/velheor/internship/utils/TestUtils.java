package com.velheor.internship.utils;

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

    public final static Truck TRUCK1 = new Truck();
    public final static Truck TRUCK2 = new Truck();
    public final static String[] TRUCK_IGNORE = new String[]{"user" };
    public final static Role ROLE1 = new Role();
    public final static Role ROLE2 = new Role();
    public final static String[] ROLE_IGNORE = new String[]{"user" };
    public final static User USER1 = new User();
    public final static User USER2 = new User();
    public final static String[] USER_IGNORE = new String[]{"carrierOrders", "shipperOrders",
            "roles", "truck" };
    public final static Order ORDER1 = new Order();
    public final static Order ORDER2 = new Order();
    public final static String[] ORDER_IGNORE = new String[]{"carrier", "shipper", "routes",
            "loads", "statuses" };
    public final static Load LOAD1 = new Load();
    public final static Load LOAD2 = new Load();
    public final static String[] LOAD_IGNORE = new String[]{"order" };
    public final static Status STATUS1 = new Status();
    public final static Status STATUS2 = new Status();
    public final static String[] STATUS_IGNORE = new String[]{"order" };
    public final static Address ADDRESS1 = new Address();
    public final static Address ADDRESS2 = new Address();
    public final static String[] ADDRESS_IGNORE = new String[]{"routeTo", "routeFrom" };
    public final static Integer EXPECTED_SIZE = 1;
    public final static UUID TEST_UUID = UUID.fromString("4690c03a-af55-11eb-8529-0242ac130003");

    static {
        TRUCK1.setId(UUID.fromString("2da16836-9c4a-11eb-a8b3-0242ac130003"));
        TRUCK1.setName("VOLVO");
        TRUCK1.setRegistrationNumber("1234VA-5");
        TRUCK1.setMaxWeight(new BigDecimal("10"));
        TRUCK1.setTruckCategory(ETruckCategory.ALL_METAL);

        TRUCK2.setId(UUID.fromString("365e1fdc-9c4a-11eb-a8b3-0242ac130003"));
        TRUCK2.setName("SCANIA");
        TRUCK2.setRegistrationNumber("2345AV-6");
        TRUCK2.setMaxWeight(new BigDecimal("5"));
        TRUCK2.setTruckCategory(ETruckCategory.ALL_METAL);

        USER1.setId(UUID.fromString("47a07384-93b8-11eb-a8b3-0242ac130003"));
        USER1.setFirstName("Test1");
        USER1.setLastName("Test1");
        USER1.setEmail("test1@gmail.com");
        USER1.setPhoneNumber("+375 (33) 123-45-67");
        USER1.setPassword("$2y$12$yVeTM63pz0oSJeet.BGEU.GxJvJdnf0FX5rGcqGl4Mk51edhBa1SC");

        USER2.setId(UUID.fromString("45caf4c2-9565-11eb-a8b3-0242ac130003"));
        USER2.setFirstName("Test2");
        USER2.setLastName("Test2");
        USER2.setEmail("test2@gmail.com");
        USER2.setPhoneNumber("+375 (33) 111-22-33");
        USER2.setPassword("$2y$12$ZN3OaMsgVkx9Z6.b.tnHSeok9zxUSVtQH9A0JFxSEhW8son/POBXi");

        ROLE1.setId(UUID.fromString("cd2d4abe-9c4a-11eb-a8b3-0242ac130003"));
        ROLE1.setName(ERole.CARRIER);
        ROLE1.setUser(USER1);

        ROLE2.setId(UUID.fromString("faf2d93a-9c4c-11eb-a8b3-0242ac130003"));
        ROLE2.setName(ERole.SHIPPER);
        ROLE1.setUser(USER2);

        ORDER1.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        ORDER1.setDatePickup(LocalDateTime.of(2021, 1, 4, 11, 30));
        ORDER1.setDateDelivery(LocalDateTime.of(2021, 1, 10, 10, 0));
        ORDER1.setPrice(new BigDecimal("4000.0"));
        ORDER1.setTruckCategory(ETruckCategory.ALL_METAL);
        ORDER1.setCarrier(USER1);
        ORDER1.setShipper(USER2);

        ORDER2.setId(UUID.fromString("3a424170-958b-11eb-a8b3-0242ac130003"));
        ORDER2.setDatePickup(LocalDateTime.of(2021, 2, 10, 11, 0));
        ORDER2.setDateDelivery(LocalDateTime.of(2021, 2, 12, 6, 0));
        ORDER2.setPrice(new BigDecimal("5000.0"));
        ORDER2.setTruckCategory(ETruckCategory.ALL_METAL);

        LOAD1.setId(UUID.fromString("5942070a-957b-11eb-a8b3-0242ac130003"));
        LOAD1.setName("FURNITURE");
        LOAD1.setWeight(new BigDecimal("0.5"));
        LOAD1.setDetails("Just furniture");
        LOAD1.setOrder(ORDER1);

        LOAD2.setId(UUID.fromString("60b523b4-957b-11eb-a8b3-0242ac130003"));
        LOAD2.setName("BEER");
        LOAD2.setWeight(new BigDecimal("23.0"));
        LOAD2.setDetails("HEINEKEN");

        STATUS1.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        STATUS1.setName(EStatus.WAITING_FOR_CARRIER);
        STATUS1.setStatusDate(LocalDateTime.of(2021, 1, 3, 11, 30));
        STATUS1.setOrder(ORDER1);

        STATUS2.setId(UUID.fromString("811f7588-96d8-11eb-a8b3-0242ac130003"));
        STATUS2.setName(EStatus.WAITING_FOR_LOADING);
        STATUS2.setStatusDate(LocalDateTime.of(2021, 1, 3, 11, 45));
        STATUS2.setOrder(ORDER2);

        ADDRESS1.setId(UUID.fromString("fe8866ce-9c4b-11eb-a8b3-0242ac130003"));
        ADDRESS1.setCountry("BELARUS");
        ADDRESS1.setCity("HRODNO");
        ADDRESS1.setStreetName("STREET");
        ADDRESS1.setStreetNumber("1337-A");

        ADDRESS2.setId(UUID.fromString("446d6234-9c4c-11eb-a8b3-0242ac130003"));
        ADDRESS2.setCountry("BELARUS");
        ADDRESS2.setCity("MINSK");
        ADDRESS2.setStreetName("STREETS");
        ADDRESS2.setStreetNumber("1373-B");
    }
}
