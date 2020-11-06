package com.raccoontruck.startup.controllers;

import com.raccoontruck.startup.dto.UserDTO;
import com.raccoontruck.startup.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final IUserService userService;

    @Autowired
    UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }
}