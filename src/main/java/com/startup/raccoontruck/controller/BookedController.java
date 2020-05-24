package com.startup.raccoontruck.controller;

import com.startup.raccoontruck.domain.Load;
import com.startup.raccoontruck.domain.User;
import com.startup.raccoontruck.repos.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

@Controller
public class BookedController {
    @Autowired
    private LoadRepo loadRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/user-loads/booked/{user}")
    public String userBookedTrips(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Load load
    ) {
        List<Load> loads = loadRepo.findByDriverIdAndStatus(user.getId(), false);
        if (currentUser.isCustomer()) {
            loads = loadRepo.findByCustomerAndStatus(currentUser, false);
        }

        model.addAttribute("loads", loads);
        model.addAttribute("load", load);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userLoads";
    }

    @PostMapping("/user-loads/booked/{user}")
    public String updateTrip(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long user,
            @RequestParam("id") Load load,
            @RequestParam(required = false) String cityFrom,
            @RequestParam(required = false) String cityTo,
            @RequestParam(required = false) String weight,
            @RequestParam(required = false) String price,
            @RequestParam(required = false) MultipartFile file
    ) throws IOException {
        if (!StringUtils.isEmpty(cityFrom) && validateString(cityFrom)) {
            load.setCityTo(cityFrom);
        }

        if (!StringUtils.isEmpty(cityTo) && validateString(cityTo)) {
            load.setCityFrom(cityTo);
        }

        if (!StringUtils.isEmpty(weight) && !checkStringForNoNumber(weight)) {
            load.setWeight(weight);
        }

        if (!StringUtils.isEmpty(price) && !checkStringForNoNumber(weight)) {
            load.setPrice(price);
        }

        if (!file.isEmpty()) {
            saveFile(load, file);
        }

        loadRepo.save(load);
        return "redirect:/user-loads/booked/" + user;
    }

    public void saveFile(@RequestParam("id") Load load, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            load.setFilename(resultFilename);

            loadRepo.save(load);
        }
    }

    public boolean validateString(String str) {
        return checkStringForLength(str) && checkStringForNoNumber(str);
    }

    public boolean checkStringForLength(String str) {
        return str.length() > 2 && str.length() < 15;
    }

    public boolean checkStringForNoNumber(String str) {
        return Pattern.matches("[a-zA-Z]+", str);
    }
}
