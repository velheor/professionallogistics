package com.velheor.internship.controllers.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
public class UserMvc {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/users")
    @SneakyThrows
    public String getAllUsers(Model model) {
        ObjectMapper objectMapper = new ObjectMapper();
        Iterable<UserViewDTO> userViewDTOS = userMapper.toUserViewDto(userService.getAll());
        model.addAttribute("users", objectMapper.writeValueAsString(userViewDTOS));
        return "users";
    }

    @PostMapping("/users")
    public String saveAllUsers(@Valid @ModelAttribute("users") Iterable<UserViewDTO> usersViewDTO) {
        userService.saveAll(userMapper.toUser(usersViewDTO));
        return "users";
    }
}
