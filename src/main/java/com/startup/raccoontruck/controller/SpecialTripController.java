package com.startup.raccoontruck.controller;

import com.startup.raccoontruck.domain.Trip;
import com.startup.raccoontruck.domain.User;
import com.startup.raccoontruck.repos.TripRepo;
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
public class SpecialTripController {
    @Autowired
    private TripRepo tripRepo;

    @GetMapping("/special-trips/{trip}")
    public String userTrips(
            @PathVariable Trip trip,
            Model model
    ) {
        Trip optionalTrip = tripRepo.findById(trip.getId()).orElse(new Trip());
        List<Trip> trips = Arrays.asList(optionalTrip);
        model.addAttribute("trips", trips);
        return "specialTrip";
    }

    @PostMapping("/special-trips/{trip}")
    public String setDriver(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Trip trip
    ) {
        trip.setDriver(currentUser.getId());
        tripRepo.save(trip);
        return "redirect:/special-trips/" + trip.getId();
    }
}
