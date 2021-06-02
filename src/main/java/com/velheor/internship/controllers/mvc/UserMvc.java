package com.velheor.internship.controllers.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.dto.form.UserViewsDtoForm;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
public class UserMvc {

    private final UserService userService;
    private final UserMapper userMapper;
    private final static String usersView = "users";

    @GetMapping("/users")
    @SneakyThrows
    public String getAllUsers(Model model) {
        ObjectMapper objectMapper = new ObjectMapper();
        model.addAttribute("userJson", objectMapper.writeValueAsString(userMapper.toUserViewDto(userService.getAll())));
        return usersView;
    }

    @PostMapping("/users")
    @SneakyThrows
    public String saveAllUsers(Model model, @ModelAttribute("userViewsDtoForm") UserViewsDtoForm userViewsDtoForms) {
        userService.saveAll(userMapper.toUser(userViewsDtoForms.getUserViewDTOS()));
        ObjectMapper objectMapper = new ObjectMapper();
        model.addAttribute("userJson", objectMapper.writeValueAsString(userMapper.toUserViewDto(userService.getAll())));
        return usersView;
    }
}
