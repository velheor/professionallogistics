package com.velheor.internship.controllers.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velheor.internship.dto.form.UserViewDtoForm;
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

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
public class UserMvcController {

    private final static String usersView = "users";
    private final UserService userService;
    private final UserMapper userMapper;
    private final ObjectMapper objectMapper;

    @GetMapping("/users")
    @SneakyThrows
    public String getAllUsers(Model model) {
        model.addAttribute("userJson", objectMapper.writeValueAsString(userMapper.toUserViewDto(userService.getAll())));
        return usersView;
    }

    @PostMapping("/users")
    @SneakyThrows
    public String saveAllUsers(Model model, @ModelAttribute("userViewDtoForm") UserViewDtoForm userViewDtoForm) {
        userService.saveAll(userMapper.toUser(userViewDtoForm.getUserViewDtos()));
        model.addAttribute("userJson", objectMapper.writeValueAsString(userMapper.toUserViewDto(userService.getAll())));
        return usersView;
    }
}
