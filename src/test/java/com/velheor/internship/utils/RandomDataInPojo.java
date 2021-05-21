package com.velheor.internship.utils;

import com.velheor.internship.models.User;
import com.velheor.internship.xml.customModels.Users;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

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

public class RandomDataInPojo {
    public void creatingTestData() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Users.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(marshaller.JAXB_ENCODING, "utf-8");
        List<User> userList = new ArrayList<>();
        Users users = new Users();

        EasyRandomParameters parameters = new EasyRandomParameters();

        parameters.excludeField(FieldPredicates.named("carrierOrders"));
        parameters.excludeField(FieldPredicates.named("shipperOrders"));
        parameters.excludeField(FieldPredicates.named("roles"));
        parameters.excludeField(FieldPredicates.named("truck"));

        EasyRandom easyRandom = new EasyRandom(parameters);

        for (int i = 0; i < 10000; i++) {
            userList.add(easyRandom.nextObject(User.class));
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
