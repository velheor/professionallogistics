package com.velheor.internship.xml;

import com.velheor.internship.models.User;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserXmlParser {

    public List<User> readFromXML(InputStream is) throws XMLStreamException, JAXBException {
        List<User> users = new ArrayList<>();
        StaxStreamProcessor<User> processor = new StaxStreamProcessor<>(is, User.class, "Users");

        while (processor.startElement()) {
            users.add(processor.getValue());
        }
        return users;
    }
}
