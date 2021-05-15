package com.velheor.internship.controllers;

import com.velheor.internship.dto.AuthUserDTO;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.email.EmailSender;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.models.User;
import com.velheor.internship.security.JwtProvider;
import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final EmailSender emailSender;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public String authenticate(@Valid @RequestBody AuthUserDTO authUserDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authUserDTO.getEmail(),
                authUserDTO.getPassword()));
        return jwtProvider.createWebToken(authUserDTO.getEmail(), userService.findByEmail(authUserDTO.getEmail()).getRoles());
    }

    @PostMapping("/signup")
    public String signUp(@Valid @RequestBody UserViewDTO userViewDTO) {
        userMapper.userToUserDto(userService.save(userMapper.userDtoToUser(userViewDTO)));

        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("firstName", userViewDTO.getFirstName());
        templateModel.put("token", jwtProvider.createMailToken(userViewDTO.getEmail()));

        emailSender.sendMessageUsingThymeleafTemplate(userViewDTO.getEmail(), "Activation code", templateModel);
        return "Check your email!";
    }

    @GetMapping("/activate/{code}")
    public String activateAccount(@PathVariable("code") String tokenMail) {
        jwtProvider.validateToken(tokenMail);
        User user = userService.findByEmail(jwtProvider.getEmail(tokenMail));
        user.setActive(true);
        userService.save(user);
        return "Account activated successfully";
    }
}
