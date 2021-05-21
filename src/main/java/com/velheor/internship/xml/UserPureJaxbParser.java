package com.velheor.internship.xml;

import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.service.UserService;
import com.velheor.internship.xml.customModels.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
@RequiredArgsConstructor
public class UserPureJaxbParser {

    private final UserService userService;
    private final UserMapper userMapper;

    public void readLargeFileWithJaxb(File path) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Users users = (Users) unmarshaller.unmarshal(path);
        userService.saveAll(userMapper.usersDtoToUser(users.getUsers()));
    }
}
