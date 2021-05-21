package com.velheor.internship.utils;

import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.models.User;
import com.velheor.internship.xml.customModels.UsersViewDTO;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

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
        JAXBContext context = JAXBContext.newInstance(UsersViewDTO.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(marshaller.JAXB_ENCODING, "utf-8");
        List<UserViewDTO> userList = new ArrayList<>();
        UsersViewDTO usersViewDTO = new UsersViewDTO();
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 10; i++) {
            userList.add(factory.manufacturePojo(UserViewDTO.class));
        }
        usersViewDTO.setUsers(userList);
        File file = new File("./src/test/resources/GeneratedTestUsers.xml");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

        try {
            marshaller.marshal(usersViewDTO, bos);
            bos.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
