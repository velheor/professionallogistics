package com.velheor.internship.utils;

import com.github.javafaker.Faker;
import com.velheor.internship.dto.UserViewDto;
import com.velheor.internship.xml.customModels.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestUsers {

    public void creatingTestData() throws JAXBException, FileNotFoundException {
        Users users = new Users();

        JAXBContext context = JAXBContext.newInstance(Users.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(marshaller.JAXB_ENCODING, "utf-8");

        users.setUsers(getUserViewDto());

        File file = new File("./src/test/resources/GeneratedTestUsers.xml");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

        try {
            marshaller.marshal(users, bos);
            bos.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public List<UserViewDto> getUserViewDto() {
        List<UserViewDto> userList = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            UserViewDto user = new UserViewDto();
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setEmail(faker.bothify("????????####@gmail.com"));
            user.setPhoneNumber(faker.regexify("\\+375 \\((17|29|33|44)\\) [0-9]{3}-[0-9]{2}-[0-9]{2}"));
            user.setPassword(faker.internet().password(8, 20));

            if (i % 2 == 0) {
                user.setStatus("ACTIVE");
            } else {
                user.setStatus("INACTIVE");
            }

            userList.add(user);
        }

        return userList;
    }
}
