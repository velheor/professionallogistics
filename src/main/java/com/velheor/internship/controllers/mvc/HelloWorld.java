package com.velheor.internship.controllers.mvc;

import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HelloWorld {

    private final UserService userService;

    @GetMapping("/helloAll")
    public String helloWorld(Model model) {
        model.addAttribute("users", userService.getAll());
        return "JspBootstrap";
    }
}
