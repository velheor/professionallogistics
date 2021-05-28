package com.velheor.internship.utils;

import com.github.javafaker.Faker;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.xml.customModels.Users;
import org.junit.jupiter.api.Test;

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
import java.util.UUID;

public class RandomDataInPojo {

    @Test
    void randomData() throws JAXBException, FileNotFoundException {
        creatingTestData();
    }

    public void creatingTestData() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Users.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(marshaller.JAXB_ENCODING, "utf-8");
        List<UserViewDTO> userList = new ArrayList<>();
        Users users = new Users();
        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            UserViewDTO user = new UserViewDTO();
            user.setId(UUID.randomUUID());
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setEmail(faker.bothify("????????####@gmail.com"));
            user.setPhoneNumber(faker.regexify("\\+375 \\((17|29|33|44)\\) [0-9]{3}-[0-9]{2}-[0-9]{2}"));
            user.setPassword(faker.internet().password(8, 20));
            userList.add(user);
        }

        users.setUsers(userList);

        File file = new File("./src/test/resources/GeneratedTestUsers.xml");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

        try {
            marshaller.marshal(users, bos);
            bos.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
