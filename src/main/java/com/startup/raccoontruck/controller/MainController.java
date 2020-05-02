package com.startup.raccoontruck.controller;

import com.startup.raccoontruck.domain.Load;
import com.startup.raccoontruck.repos.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private LoadRepo loadRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String cityFrom, String cityTo, String weight, String price, Model model) {
        Iterable<Load> loads = loadRepo.findByDriverId(null);

        if ((cityFrom != null && !cityFrom.isEmpty()) || (cityTo != null && !cityTo.isEmpty()) || (weight != null && !weight.isEmpty()) || (price != null && !price.isEmpty())) {
            loads = loadRepo.findByCityFromOrCityToOrWeightOrPrice(cityFrom, cityTo, weight, price);
        }

        model.addAttribute("loads", loads);

        return "main";
    }


}