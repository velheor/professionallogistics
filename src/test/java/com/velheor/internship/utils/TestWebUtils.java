package com.velheor.internship.utils;

import com.velheor.internship.dto.AddressViewDTO;
import com.velheor.internship.dto.LoadViewDTO;
import com.velheor.internship.dto.OrderViewDTO;
import com.velheor.internship.dto.RoleViewDTO;
import com.velheor.internship.dto.StatusViewDTO;
import com.velheor.internship.dto.TruckViewDTO;
import com.velheor.internship.dto.UserViewDTO;

import static com.velheor.internship.utils.TestUtils.ADDRESS1;
import static com.velheor.internship.utils.TestUtils.ADDRESS2;
import static com.velheor.internship.utils.TestUtils.LOAD1;
import static com.velheor.internship.utils.TestUtils.LOAD2;
import static com.velheor.internship.utils.TestUtils.ORDER1;
import static com.velheor.internship.utils.TestUtils.ORDER2;
import static com.velheor.internship.utils.TestUtils.ROLE1;
import static com.velheor.internship.utils.TestUtils.ROLE2;
import static com.velheor.internship.utils.TestUtils.STATUS1;
import static com.velheor.internship.utils.TestUtils.STATUS2;
import static com.velheor.internship.utils.TestUtils.TRUCK1;
import static com.velheor.internship.utils.TestUtils.TRUCK2;
import static com.velheor.internship.utils.TestUtils.USER1;
import static com.velheor.internship.utils.TestUtils.USER2;

public final class TestWebUtils {

    public final static TruckViewDTO TRUCK_VIEW_DTO1 = new TruckViewDTO();
    public final static TruckViewDTO TRUCK_VIEW_DTO2 = new TruckViewDTO();

    public final static UserViewDTO USER_VIEW_DTO1 = new UserViewDTO();
    public final static UserViewDTO USER_VIEW_DTO2 = new UserViewDTO();

    public final static RoleViewDTO ROLE_VIEW_DTO1 = new RoleViewDTO();
    public final static RoleViewDTO ROLE_VIEW_DTO2 = new RoleViewDTO();

    public final static OrderViewDTO ORDER_VIEW_DTO1 = new OrderViewDTO();
    public final static OrderViewDTO ORDER_VIEW_DTO2 = new OrderViewDTO();

    public final static LoadViewDTO LOAD_VIEW_DTO1 = new LoadViewDTO();
    public final static LoadViewDTO LOAD_VIEW_DTO2 = new LoadViewDTO();

    public final static StatusViewDTO STATUS_VIEW_DTO1 = new StatusViewDTO();
    public final static StatusViewDTO STATUS_VIEW_DTO2 = new StatusViewDTO();

    public final static AddressViewDTO ADDRESS_VIEW_DTO1 = new AddressViewDTO();
    public final static AddressViewDTO ADDRESS_VIEW_DTO2 = new AddressViewDTO();

    static {
        TRUCK_VIEW_DTO1.setId(TRUCK1.getId());
        TRUCK_VIEW_DTO1.setName(TRUCK1.getName());
        TRUCK_VIEW_DTO1.setRegistrationNumber(TRUCK1.getRegistrationNumber());
        TRUCK_VIEW_DTO1.setMaxWeight(TRUCK1.getMaxWeight());
        TRUCK_VIEW_DTO1.setTruckCategory(TRUCK1.getTruckCategory().toString());

        TRUCK_VIEW_DTO2.setId(TRUCK2.getId());
        TRUCK_VIEW_DTO2.setName(TRUCK2.getName());
        TRUCK_VIEW_DTO2.setRegistrationNumber(TRUCK2.getRegistrationNumber());
        TRUCK_VIEW_DTO2.setMaxWeight(TRUCK2.getMaxWeight());
        TRUCK_VIEW_DTO2.setTruckCategory(TRUCK2.getTruckCategory().toString());

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

        ROLE_VIEW_DTO1.setId(ROLE1.getId());
        ROLE_VIEW_DTO1.setName(ROLE1.getName().toString());

        ROLE_VIEW_DTO2.setId(ROLE2.getId());
        ROLE_VIEW_DTO2.setName(ROLE2.getName().toString());

        ORDER_VIEW_DTO1.setId(ORDER1.getId());
        ORDER_VIEW_DTO1.setDatePickup(ORDER1.getDatePickup());
        ORDER_VIEW_DTO1.setDateDelivery(ORDER1.getDateDelivery());
        ORDER_VIEW_DTO1.setPrice(ORDER1.getPrice());
        ORDER_VIEW_DTO1.setTruckCategory(ORDER1.getTruckCategory().toString());

        ORDER_VIEW_DTO2.setId(ORDER2.getId());
        ORDER_VIEW_DTO2.setDatePickup(ORDER2.getDatePickup());
        ORDER_VIEW_DTO2.setDateDelivery(ORDER2.getDateDelivery());
        ORDER_VIEW_DTO2.setPrice(ORDER2.getPrice());
        ORDER_VIEW_DTO2.setTruckCategory(ORDER2.getTruckCategory().toString());

        LOAD_VIEW_DTO1.setId(LOAD1.getId());
        LOAD_VIEW_DTO1.setName(LOAD1.getName());
        LOAD_VIEW_DTO1.setWeight(LOAD1.getWeight());
        LOAD_VIEW_DTO1.setDescription(LOAD1.getDetails());

        LOAD_VIEW_DTO2.setId(LOAD2.getId());
        LOAD_VIEW_DTO2.setName(LOAD2.getName());
        LOAD_VIEW_DTO2.setWeight(LOAD2.getWeight());
        LOAD_VIEW_DTO2.setDescription(LOAD2.getDetails());

        STATUS_VIEW_DTO1.setId(STATUS1.getId());
        STATUS_VIEW_DTO1.setName(STATUS1.getName().toString());
        STATUS_VIEW_DTO1.setStatusDate(STATUS1.getStatusDate());

        STATUS_VIEW_DTO2.setId(STATUS2.getId());
        STATUS_VIEW_DTO2.setName(STATUS2.getName().toString());
        STATUS_VIEW_DTO2.setStatusDate(STATUS2.getStatusDate());

        ADDRESS_VIEW_DTO1.setId(ADDRESS1.getId());
        ADDRESS_VIEW_DTO1.setCountry(ADDRESS1.getCountry());
        ADDRESS_VIEW_DTO1.setCity(ADDRESS1.getCity());
        ADDRESS_VIEW_DTO1.setStreetName(ADDRESS1.getStreetName());
        ADDRESS_VIEW_DTO1.setStreetNumber(ADDRESS1.getStreetNumber());

        ADDRESS_VIEW_DTO2.setId(ADDRESS2.getId());
        ADDRESS_VIEW_DTO2.setCountry(ADDRESS2.getCountry());
        ADDRESS_VIEW_DTO2.setCity(ADDRESS2.getCity());
        ADDRESS_VIEW_DTO2.setStreetName(ADDRESS2.getStreetName());
        ADDRESS_VIEW_DTO2.setStreetNumber(ADDRESS2.getStreetNumber());
    }
}
