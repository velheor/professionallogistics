package com.velheor.internship.service.impl;

import com.velheor.internship.models.Load;
import com.velheor.internship.models.Order;
import com.velheor.internship.models.Route;
import com.velheor.internship.models.Status;
import com.velheor.internship.models.Truck;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import com.velheor.internship.models.enums.EStatusHistory;
import com.velheor.internship.models.enums.ETruckCategory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public final class UtilTest {

    static User USER1;
    static User USER2;
    static Truck TRUCK1;
    static Truck TRUCK2;
    static Order ORDER1;
    static Order ORDER2;
    static Load LOAD1;
    static Load LOAD2;
    static Status STATUS1;
    static Status STATUS2;
    static Route ROUTE1;
    static Route ROUTE2;
    static Integer EXPECTED_SIZE = 1;

    static {
        setUpUser();
        setUpTruck();
        setUpOrder();
        setUpLoad();
        setUpStatusHistory();
        setUpOrderAddress();
    }

    private UtilTest() {
    }

    static void setUpUser() {
        USER1 = new User();
        USER1.setId(UUID.fromString("47a07384-93b8-11eb-a8b3-0242ac130003"));
        USER1.setFirstName("Ivan");
        USER1.setLastName("Ivanov");
        USER1.setEmail("ivan@gmail.com");
        USER1.setPhoneNumber("+375331234567");
        USER1.setPassword("pass1");
        USER1.setRole(ERole.CARRIER);

        USER2 = new User();
        USER2.setId(UUID.fromString("45caf4c2-9565-11eb-a8b3-0242ac130003"));
        USER2.setFirstName("Petr");
        USER2.setLastName("Petrov");
        USER2.setEmail("petr@gmail.com");
        USER2.setPhoneNumber("+375296888258");
        USER2.setPassword("pass2");
        USER2.setRole(ERole.CARRIER);
    }

    static void setUpTruck() {
        TRUCK1 = new Truck();
        TRUCK1.setId(UUID.fromString("a0a81b2e-9725-11eb-a8b3-0242ac130003"));
        TRUCK1.setName("VOLVO");
        TRUCK1.setRegistrationNumber("1234VA-5");
        TRUCK1.setMaxWeight(new BigDecimal(10));
        TRUCK1.setTruckCategory(ETruckCategory.ALL_METAL);

        TRUCK2 = new Truck();
        TRUCK2.setId(UUID.fromString("886c0c76-9727-11eb-a8b3-0242ac130003"));
        TRUCK2.setName("SCANIA");
        TRUCK2.setRegistrationNumber("2345AV-6");
        TRUCK2.setMaxWeight(new BigDecimal(11));
        TRUCK2.setTruckCategory(ETruckCategory.ALL_METAL);
    }

    static void setUpOrder() {
        ORDER1 = new Order();
        ORDER1.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        ORDER1.setDatePickup(LocalDateTime.of(2021, 1, 3, 11, 30));
        ORDER1.setDateDelivery(LocalDateTime.of(2021, 1, 10, 10, 0));
        ORDER1.setPrice(new BigDecimal(4000));

        ORDER2 = new Order();
        ORDER2.setId(UUID.fromString("3a424170-958b-11eb-a8b3-0242ac130003"));
        ORDER2.setDateDelivery(LocalDateTime.of(2021, 2, 10, 12, 0));
        ORDER2.setDatePickup(LocalDateTime.of(2021, 2, 12, 6, 0));
        ORDER2.setPrice(new BigDecimal(5000));
    }

    static void setUpLoad() {
        LOAD1 = new Load();
        LOAD1.setId(UUID.fromString("5942070a-957b-11eb-a8b3-0242ac130003"));
        LOAD1.setName("FURNITURE");
        LOAD1.setWeight(new BigDecimal("0.5"));
        LOAD1.setDetails("Just furniture");
        LOAD1.setOrder(ORDER1);

        LOAD2 = new Load();
        LOAD2.setId(UUID.fromString("60b523b4-957b-11eb-a8b3-0242ac130003"));
        LOAD2.setName("BEER");
        LOAD2.setWeight(new BigDecimal(23));
        LOAD2.setDetails("HEINEKEN");
        LOAD2.setOrder(ORDER2);
    }

    static void setUpStatusHistory() {
        STATUS1 = new Status();
        STATUS1.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        STATUS1.setName(EStatusHistory.STARTED);
        STATUS1.setStatusDate(LocalDateTime.of(2020, 1, 4, 11, 30));
        STATUS1.setOrder(ORDER1);

        STATUS2 = new Status();
        STATUS2.setId(UUID.fromString("811f7588-96d8-11eb-a8b3-0242ac130003"));
        STATUS2.setName(EStatusHistory.ENDED);
        STATUS2.setStatusDate(LocalDateTime.of(2021, 1, 4, 11, 30));
        STATUS2.setOrder(ORDER2);
    }

    static void setUpOrderAddress() {
        ROUTE1 = new Route();
        ROUTE1.setId(UUID.fromString("a12ee7be-9589-11eb-a8b3-0242ac130003"));
        ROUTE1.setAddressTo("HRODNO");
        ROUTE1.setAddressFrom("MINSK");
        ROUTE1.setOrder(ORDER1);

        ROUTE2 = new Route();
        ROUTE2.setId(UUID.fromString("a678774e-9589-11eb-a8b3-0242ac130003"));
        ROUTE2.setAddressTo("VITEBSK");
        ROUTE2.setAddressFrom("BREST");
        ROUTE2.setOrder(ORDER2);
    }
}
