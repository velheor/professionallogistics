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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookedController {
    @Autowired
    private LoadRepo loadRepo;

    @GetMapping("/user-loads/booked/{user}")
    public String userBookedTrips(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Load load
    ) {
        Iterable<Load> loads = user.getLoads();
        if (currentUser.isDriver()) {
            loads = loadRepo.findByDriverIdAndStatus(user.getId(), false);
        }
        model.addAttribute("loads", loads);
        model.addAttribute("load", load);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userLoads";
    }
}
