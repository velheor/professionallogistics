package com.velheor.internship.controllers.mvc;

import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
public class UserMvc {

    private final UserService userService;

    @GetMapping("/users")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "JspBootstrap";
    }
}
