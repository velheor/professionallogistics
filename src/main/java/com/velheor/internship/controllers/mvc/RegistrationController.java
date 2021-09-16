package com.velheor.internship.controllers.mvc;

import com.velheor.internship.dto.UserRegistrationDto;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/mvc")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/signup")
    public String registration() {
        return "mvc/registrationForm";
    }

    @PostMapping("/signup")
    public String signUp(@Valid UserRegistrationDto userRegistrationDTO) {

        userService.registerUser(userMapper.toUser(userRegistrationDTO));
        userService.sendActivationCodeToEmail(userMapper.toUser(userRegistrationDTO));

        return registration();
    }
}
