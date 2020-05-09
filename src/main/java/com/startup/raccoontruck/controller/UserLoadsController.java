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

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UserLoadsController {
    @Autowired
    private LoadRepo loadRepo;

    @Value("${upload.path}")
    private static String uploadPath;

    @GetMapping("/user-loads/{user}")
    public String userTrips(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Load load
    ) {
        Iterable<Load> loads = user.getLoads();
        if (currentUser.isDriver()) {
            loads = loadRepo.findByDriverId(user.getId());
        }
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
            @RequestParam("price") String price,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        if (load.getCustomer().equals(currentUser) || load.getDriver().equals(currentUser.getId())) {
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

            saveFile(load, file);

            loadRepo.save(load);
        }
        return "redirect:/user-loads/" + user;
    }

    private void saveFile(@Valid Load load, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(String.format("%s%s%s", System.getProperty("user.dir"), File.separatorChar, uploadPath));
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String currentPath = uploadDir.getPath();
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(currentPath + "/" + resultFileName));

            load.setFilename(resultFileName);
        }
    }
}