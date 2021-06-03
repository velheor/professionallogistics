package com.velheor.internship.xml;

import com.velheor.internship.dto.UserViewDto;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.models.User;
import com.velheor.internship.service.UserService;
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

    private final UserService userService;
    private final UserMapper userMapper;

    public void readUsersFromXML(InputStream is) throws XMLStreamException, JAXBException {
        List<UserViewDto> users = new ArrayList<>();
        StaxStreamProcessor<UserViewDto> processor = new StaxStreamProcessor<>(is, UserViewDto.class, "Users");

        while (processor.startElement()) {
            users.add(processor.getValue());
            if (users.size() == 100) {
                userService.saveAll(userMapper.toUser(users));
                users.clear();
            }
        }
        userService.saveAll(userMapper.toUser(users));
    }
}
