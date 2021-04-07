package com.velheor.internship.service.impl;

import com.velheor.internship.models.Load;
import com.velheor.internship.models.Order;
import com.velheor.internship.models.OrderAddress;
import com.velheor.internship.models.StatusHistory;
import com.velheor.internship.models.Truck;
import com.velheor.internship.models.TruckCategory;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import com.velheor.internship.models.enums.EStatusHistory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BaseTest {

    static User userExpected;
    static User userExistsInDB;

    static TruckCategory truckCategoryExpected;
    static TruckCategory truckCategoryExistsInDB;

    static Truck truckExpected;
    static Truck truckExistsInDB;

    static Order orderExpected;
    static Order orderExistsInDB;

    static Load loadExpected;
    static Load loadExistsInDB;

    static StatusHistory statusHistoryExpected;
    static StatusHistory statusHistoryExistsInDB;

    static OrderAddress orderAddressExpected;
    static OrderAddress orderAddressExistInDB;

    static {
        setUpUser();
        setUpTruckCategory();
        setUpTruck();
        setUpOrder();
        setUpLoad();
        setUpStatusHistory();
        setUpOrderAddress();
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

        userExistsInDB = new User();
        userExistsInDB.setId(UUID.fromString("45caf4c2-9565-11eb-a8b3-0242ac130003"));
        userExistsInDB.setFirstName("Petr");
        userExistsInDB.setLastName("Petrov");
        userExistsInDB.setEmail("petr@gmail.com");
        userExistsInDB.setPhoneNumber("+375296888258");
        userExistsInDB.setPassword("pass2");
        userExistsInDB.setRole(ERole.CARRIER);
    }

    static void setUpTruckCategory() {
        truckCategoryExpected = new TruckCategory();
        truckCategoryExpected.setId(0);
        truckCategoryExpected.setName("COVERED");

        truckCategoryExistsInDB = new TruckCategory();
        truckCategoryExistsInDB.setId(1);
        truckCategoryExistsInDB.setName("ALL-METAL");
        truckCategoryExistsInDB.setTruckCategory(truckCategoryExpected);
    }

    static void setUpTruck() {
        truckExpected = new Truck();
        truckExpected.setId(UUID.fromString("a0a81b2e-9725-11eb-a8b3-0242ac130003"));
        truckExpected.setName("VOLVO");
        truckExpected.setRegistrationNumber("1234VA-5");
        truckExpected.setMaxWeight(new BigDecimal(10));
        truckExpected.setTruckCategory(truckCategoryExistsInDB);

        truckExistsInDB = new Truck();
        truckExistsInDB.setId(UUID.fromString("886c0c76-9727-11eb-a8b3-0242ac130003"));
        truckExistsInDB.setName("SCANIA");
        truckExistsInDB.setRegistrationNumber("2345AV-6");
        truckExistsInDB.setMaxWeight(new BigDecimal(11));
        truckExistsInDB.setTruckCategory(truckCategoryExistsInDB);
    }

    static void setUpOrder() {
        orderExpected = new Order();
        orderExpected.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        orderExpected.setDatePickup(LocalDateTime.of(2021, 1, 3, 11, 30));
        orderExpected.setDateDelivery(LocalDateTime.of(2021, 1, 10, 10, 0));
        orderExpected.setPrice(new BigDecimal(4000));

        orderExistsInDB = new Order();
        orderExistsInDB.setId(UUID.fromString("3a424170-958b-11eb-a8b3-0242ac130003"));
        orderExistsInDB.setDateDelivery(LocalDateTime.of(2021, 2, 10, 12, 0));
        orderExistsInDB.setDatePickup(LocalDateTime.of(2021, 2, 12, 6, 0));
        orderExistsInDB.setPrice(new BigDecimal(5000));
    }

    static void setUpLoad() {
        loadExpected = new Load();
        loadExpected.setId(UUID.fromString("5942070a-957b-11eb-a8b3-0242ac130003"));
        loadExpected.setName("FURNITURE");
        loadExpected.setWeight(new BigDecimal("0.5"));
        loadExpected.setDetails("Just furniture");
        loadExpected.setOrder(orderExpected);

        loadExistsInDB = new Load();
        loadExistsInDB.setId(UUID.fromString("60b523b4-957b-11eb-a8b3-0242ac130003"));
        loadExistsInDB.setName("BEER");
        loadExistsInDB.setWeight(new BigDecimal(23));
        loadExistsInDB.setDetails("HEINEKEN");
        loadExistsInDB.setOrder(orderExistsInDB);
    }

    static void setUpStatusHistory() {
        statusHistoryExpected = new StatusHistory();
        statusHistoryExpected.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        statusHistoryExpected.setName(EStatusHistory.STARTED);
        statusHistoryExpected.setStatusDate(LocalDateTime.of(2020, 1, 4, 11, 30));
        statusHistoryExpected.setOrder(orderExpected);

        statusHistoryExistsInDB = new StatusHistory();
        statusHistoryExistsInDB.setId(UUID.fromString("811f7588-96d8-11eb-a8b3-0242ac130003"));
        statusHistoryExistsInDB.setName(EStatusHistory.ENDED);
        statusHistoryExistsInDB.setStatusDate(LocalDateTime.of(2021, 1, 4, 11, 30));
        statusHistoryExistsInDB.setOrder(orderExistsInDB);
    }

    static void setUpOrderAddress() {
        orderAddressExpected = new OrderAddress();
        orderAddressExpected.setId(UUID.fromString("a12ee7be-9589-11eb-a8b3-0242ac130003"));
        orderAddressExpected.setAddressTo("HRODNO");
        orderAddressExpected.setAddressFrom("MINSK");
        orderAddressExpected.setOrder(orderExpected);

        orderAddressExistInDB = new OrderAddress();
        orderAddressExistInDB.setId(UUID.fromString("a678774e-9589-11eb-a8b3-0242ac130003"));
        orderAddressExistInDB.setAddressTo("VITEBSK");
        orderAddressExistInDB.setAddressFrom("BREST");
        orderAddressExistInDB.setOrder(orderExistsInDB);
    }
}
