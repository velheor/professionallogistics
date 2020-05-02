package com.startup.raccoontruck.controller;

import com.startup.raccoontruck.domain.Trip;
import com.startup.raccoontruck.domain.User;
import com.startup.raccoontruck.repos.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    private TripRepo tripRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String cityFrom, String cityTo, String weight, String price, Model model) {
        Iterable<Trip> trips = tripRepo.findByDriverId(null);

        if ((cityFrom != null && !cityFrom.isEmpty()) || (cityTo != null && !cityTo.isEmpty()) || (weight != null && !weight.isEmpty()) || (price != null && !price.isEmpty())) {
            trips = tripRepo.findByCityFromOrCityToOrWeightOrPrice(cityFrom, cityTo, weight, price);
        }

        model.addAttribute("trips", trips);

        return "main";
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
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

    @GetMapping("/user-trips/{user}")
    public String userTrips(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Trip trip
    ) {
        Set<Trip> trips = user.getTrips();

        model.addAttribute("trips", trips);
        model.addAttribute("trip", trip);
        model.addAttribute("isCurrentUserId", currentUser.equals(user));

        return "userTrips";
    }

    @PostMapping("/user-trips/{user}")
    public String updateTrip(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long user,
            @RequestParam("id") Trip trip,
            @RequestParam("cityFrom") String cityFrom,
            @RequestParam("cityTo") String cityTo,
            @RequestParam("weight") String weight,
            @RequestParam("price") String price
    ) {
        if (trip.getCustomer().equals(currentUser)) {
            if (!StringUtils.isEmpty(cityFrom)) {
                trip.setCityTo(cityFrom);
            }

            if (!StringUtils.isEmpty(cityTo)) {
                trip.setCityFrom(cityTo);
            }

            if (!StringUtils.isEmpty(weight)) {
                trip.setWeight(weight);
            }

            if (!StringUtils.isEmpty(price)) {
                trip.setPrice(price);
            }

            tripRepo.save(trip);
        }

        return "redirect:/user-trips/" + user;
    }
}