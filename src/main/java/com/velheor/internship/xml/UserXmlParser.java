package com.velheor.internship.xml;

import com.velheor.internship.models.User;
import com.velheor.internship.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserXmlParser {

    private final UserRepository userRepository;

    public List<User> readUsersFromXML(InputStream is) throws XMLStreamException, JAXBException {
        List<User> users = new ArrayList<>();
        StaxStreamProcessor<User> processor = new StaxStreamProcessor<>(is, User.class, "Users");

        while (processor.startElement()) {
            users.add(processor.getValue());
        }
        return users;
    }
}
