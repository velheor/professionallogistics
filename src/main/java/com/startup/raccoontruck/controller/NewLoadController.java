package com.startup.raccoontruck.controller;

import com.startup.raccoontruck.domain.Load;
import com.startup.raccoontruck.domain.User;
import com.startup.raccoontruck.repos.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class NewLoadController {
    @Autowired
    private LoadRepo loadRepo;

    @GetMapping("/create")
    public String showMenuOfCreate() {
        return "createLoad";
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping("/create")
    public String addTrip(
            @AuthenticationPrincipal User user,
            @Valid Load load,
            BindingResult bindingResult,
            Model model
    ) {
        load.setCustomer(user);
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("load", load);
        } else {
            loadRepo.save(load);
        }

        return "redirect:/user-loads/" + user;
    }

}