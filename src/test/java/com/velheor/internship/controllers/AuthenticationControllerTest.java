package com.velheor.internship.controllers;

import com.velheor.internship.BaseWebTest;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.exception.ErrorMessage;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.mappers.UserMapperImpl;
import com.velheor.internship.security.JwtProvider;
import com.velheor.internship.email.EmailSender;
import com.velheor.internship.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static com.velheor.internship.utils.TestUtils.USER1;
import static com.velheor.internship.utils.TestWebUtils.AUTH_URL;
import static com.velheor.internship.utils.TestWebUtils.AUTH_USER_DTO;
import static com.velheor.internship.utils.TestWebUtils.USER_VIEW_DTO1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthenticationControllerTest extends BaseWebTest {
/*
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    private UserService userService;
    private EmailSender emailSender;
    private AuthenticationController authController;

    public AuthenticationControllerTest() {
        setUp(() -> {
            emailSender = mock(EmailSender.class);
            userService = mock(UserService.class);
            UserMapper userMapper = new UserMapperImpl();
            return authController;
        });
    }

    @Test
    void authenticate() throws Exception {
        when(userService.findByEmail(USER1.getEmail())).thenReturn(USER1);
        String jwt = mockMvc.perform(post(AUTH_URL + "login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(AUTH_USER_DTO)))
                .andExpect(status().isOk()).andReturn().getResponse().toString();
        System.out.println(jwt);
    }

    @Test
    void signUp() throws Exception {
        mockMvc.perform(post(AUTH_URL + "signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(USER_VIEW_DTO1)))
                .andExpect(status().isOk());
    }

    @Test
    void signUpThrowHandleMethodArgumentNotValid() throws Exception {
        UserViewDTO testUser = new UserViewDTO(USER_VIEW_DTO1);
        testUser.setPassword("test");
        testUser.setPhoneNumber("+1234");

        String responseBody = mockMvc.perform(post(AUTH_URL + "signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testUser)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andReturn().getResponse().getContentAsString();
        ErrorMessage actual = objectMapper.readValue(responseBody, ErrorMessage.class);
        int countOfErrors = 2;
        assertThat(actual.getErrors().size()).isEqualTo(countOfErrors);
    }*/
}