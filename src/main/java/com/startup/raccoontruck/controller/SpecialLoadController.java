package com.startup.raccoontruck.controller;

import com.startup.raccoontruck.domain.Load;
import com.startup.raccoontruck.domain.User;
import com.startup.raccoontruck.repos.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class SpecialLoadController {
    @Autowired
    private LoadRepo loadRepo;

    @GetMapping("/special-loads/{load}")
    public String userLoads(
            @PathVariable Load load,
            Model model
    ) {
        Load optionalLoad = loadRepo.findById(load.getId()).orElse(new Load());
        List<Load> loads = Arrays.asList(optionalLoad);
        model.addAttribute("loads", loads);
        return "specialLoad";
    }

    @PostMapping("/special-loads/{load}")
    public String setDriver(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Load load
    ) {
        load.setDriver(currentUser.getId());
        loadRepo.save(load);
        return "redirect:/special-loads/" + load.getId();
    }
}