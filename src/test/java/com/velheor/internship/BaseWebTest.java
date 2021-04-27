package com.velheor.internship;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velheor.internship.conf.SecurityConfig;
import com.velheor.internship.config.PersistenceTestConfig;
import com.velheor.internship.config.WebTestConfig;
import java.util.function.Supplier;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@SpringJUnitWebConfig(
    classes = {
        WebTestConfig.class, PersistenceTestConfig.class, SecurityConfig.class,
    })
public abstract class BaseWebTest {

    public ObjectMapper objectMapper;

    protected MockMvc mockMvc;

    private StandaloneMockMvcBuilder standaloneMockMvcBuilder;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    public void setUp(Supplier<Object> controllerSupplier) {
        objectMapper = new ObjectMapper();
        standaloneMockMvcBuilder = MockMvcBuilders
            .standaloneSetup(controllerSupplier.get());
    }

    @PostConstruct
    private void setUpMockMvc() {
        mockMvc = standaloneMockMvcBuilder.apply(springSecurity(springSecurityFilterChain)).build();
    }
}
