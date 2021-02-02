package com.raccoontruck.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class AuthController {
    private IUserService userService;

    @Autowired
    AuthController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
    ) {

        return "redirect:/login";
    }
}
