package com.velheor.internship.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CostMvcController {

    @GetMapping("/view/costs")
    public String welcome() {
        return "/rest/costs";
    }
}
