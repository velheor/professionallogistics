package com.startup.raccoontruck.controller;

import com.startup.raccoontruck.domain.Load;
import com.startup.raccoontruck.domain.User;
import com.startup.raccoontruck.repos.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class UserLoadsController {
    @Autowired
    private LoadRepo loadRepo;

    @GetMapping("/user-loads/{user}")
    public String userTrips(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Load load
    ) {
        Set<Load> loads = user.getLoads();

        model.addAttribute("loads", loads);
        model.addAttribute("load", load);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userLoads";
    }

    @PostMapping("/user-loads/{user}")
    public String updateTrip(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long user,
            @RequestParam("id") Load load,
            @RequestParam("cityFrom") String cityFrom,
            @RequestParam("cityTo") String cityTo,
            @RequestParam("weight") String weight,
            @RequestParam("price") String price
    ) {
        if (load.getCustomer().equals(currentUser)) {
            if (!StringUtils.isEmpty(cityFrom)) {
                load.setCityTo(cityFrom);
            }

            if (!StringUtils.isEmpty(cityTo)) {
                load.setCityFrom(cityTo);
            }

            if (!StringUtils.isEmpty(weight)) {
                load.setWeight(weight);
            }

            if (!StringUtils.isEmpty(price)) {
                load.setPrice(price);
            }

            loadRepo.save(load);
        }

        return "redirect:/user-loads/" + user;
    }
}
