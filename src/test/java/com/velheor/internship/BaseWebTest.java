package com.velheor.internship;

import com.velheor.internship.conf.MySpringMvcDispatcherSerlvetIntitializer;
import com.velheor.internship.conf.PersistenceConfig;
import com.velheor.internship.conf.SecurityConfig;
import com.velheor.internship.conf.SecurityWebInitializer;
import com.velheor.internship.conf.WebConfig;
import com.velheor.internship.config.WebTestConfig;
import com.velheor.internship.repository.UserRepository;
import com.velheor.internship.service.UserService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig(
    classes = {
        WebTestConfig.class, WebConfig.class, SecurityWebInitializer.class,
        SecurityConfig.class, MySpringMvcDispatcherSerlvetIntitializer.class,
        UserService.class, UserRepository.class, PersistenceConfig.class
    })
public abstract class BaseWebTest {

}
