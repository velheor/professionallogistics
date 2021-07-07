package com.velheor.internship;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.velheor.internship.conf.SecurityConfig;
import com.velheor.internship.config.WebTestConfig;
import com.velheor.internship.exception.RestExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.validation.Validator;

import javax.annotation.PostConstruct;
import java.util.function.Supplier;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringJUnitWebConfig(
        classes = {
                WebTestConfig.class, SecurityConfig.class
        })
public abstract class BaseWebTest {

    public ObjectMapper objectMapper;
    protected MockMvc mockMvc;
    private StandaloneMockMvcBuilder standaloneMockMvcBuilder;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private Validator validator;

    public void setUp(Supplier<Object> controllerSupplier) {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        standaloneMockMvcBuilder = MockMvcBuilders
                .standaloneSetup(controllerSupplier.get())
                .setControllerAdvice(new RestExceptionHandler());
    }

    @PostConstruct
    private void setUpMockMvc() {
        mockMvc = standaloneMockMvcBuilder
                .apply(springSecurity(springSecurityFilterChain))
                .setValidator(validator)
                .build();
    }
}
