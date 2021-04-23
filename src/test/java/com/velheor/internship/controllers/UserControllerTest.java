package com.velheor.internship.controllers;

import static com.velheor.internship.utils.TestUtils.USER1;
import static com.velheor.internship.utils.TestWebUtils.USER_VIEW1;
import static org.mockito.Mockito.doReturn;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.velheor.internship.BaseWebTest;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class UserControllerTest extends BaseWebTest {

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    UserControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders
            .standaloneSetup(new UserController(userService, userMapper, passwordEncoder))
            .apply(springSecurity(springSecurityFilterChain))
            .build();
    }

    @Test
    void findById() throws Exception {
        doReturn(USER1).when(userService).findById(USER1.getId());

        mockMvc.perform(get("/users/" + USER1.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn(USER_VIEW1);
    }

    @Test
    void findByIdBadRequest() throws Exception {
        mockMvc.perform(get("/users/notValidText")).andExpect(status().isBadRequest());
    }

    @Test
    void findByEmail() throws Exception {
        doReturn(USER1).when(userService).findByEmail(USER1.getEmail());
        mockMvc.perform(get("/users/findByEmail/" + USER1.getEmail()))
            .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }
}