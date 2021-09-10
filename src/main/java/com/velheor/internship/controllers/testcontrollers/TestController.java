package com.velheor.internship.controllers.testcontrollers;

import com.velheor.internship.utils.TestCosts;
import com.velheor.internship.utils.TestOrders;
import com.velheor.internship.xml.UserPureJaxbParser;
import com.velheor.internship.xml.UserXmlParser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final UserXmlParser userXmlParser;
    private final UserPureJaxbParser userPureJaxbParser;
    private final TestOrders testOrders;
    private final TestCosts testCosts;

    @GetMapping("/xml/users")
    @SneakyThrows
    public void test() {
        userXmlParser.readUsersFromXML(new ClassPathResource("GeneratedTestUsers.xml").getInputStream());
    }

    @GetMapping("/xml/users/full")
    @SneakyThrows
    public void full() {
        userPureJaxbParser.readLargeFileWithJaxb(new ClassPathResource("GeneratedTestUsers.xml").getFile());
    }

    @GetMapping("/orders/")
    public void fillDbOrders() {
        testOrders.createTestData();
    }

    @GetMapping("/costs/")
    public void fillDbCosts() {
        testCosts.createTestData();
    }
}
