package com.startup.raccoontruck.controller;

import com.startup.raccoontruck.domain.Trip;
import com.startup.raccoontruck.domain.User;
import com.startup.raccoontruck.repos.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private TripRepo tripRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String cityFrom, String cityTo, String price, String weight, Model model) {
        Iterable<Trip> trips;

        if (price != null && !price.isEmpty()) {
            trips = tripRepo.findByPriceAndCityFromAndCityToAndWeight(cityTo, cityFrom, price, weight);
        } else {
            trips = tripRepo.findAll();
        }

        model.addAttribute("trips", trips);
        model.addAttribute("filter", cityTo);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Trip trip,
            BindingResult bindingResult,
            Model model
    ) {
        trip.setCustomer(user);
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("trip", trip);
        } else {
            tripRepo.save(trip);
        }

        Iterable<Trip> trips = tripRepo.findAll();

        model.addAttribute("trips", trips);

        return "main";
    }
}
