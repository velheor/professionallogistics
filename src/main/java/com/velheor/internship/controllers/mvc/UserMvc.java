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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
public class UserMvc {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/users/{page}/{count}")
    @SneakyThrows
    public String getAllUsers(Model model, @PathVariable("page") Integer page, @PathVariable("count") Integer count) {
        ObjectMapper objectMapper = new ObjectMapper();
        Iterable<UserViewDTO> userViewDTOS = userMapper.toUserViewDto(userService.findAll(page, count));
        model.addAttribute("users", objectMapper.writeValueAsString(userViewDTOS));
        return "users";
    }

    @PostMapping("/users")
    public String saveAllUsers(@Valid @ModelAttribute UserViewsDtoForm viewsDtoForm) {
        userService.saveAll(userMapper.toUser(viewsDtoForm.getUserViewDTOS()));
        return "users";
    }
}
