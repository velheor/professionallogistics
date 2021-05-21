package com.velheor.internship.xml;

import com.velheor.internship.xml.customModels.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class PureJaxbParser {

    public void readLargeFileWithJaxb(String path) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Users obj = (Users) unmarshaller.unmarshal(new File(path));
    }
}
