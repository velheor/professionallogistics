package com.velheor.internship.controllers;

import com.velheor.internship.dto.AuthUserDTO;
import com.velheor.internship.models.User;
import com.velheor.internship.security.jwt.JwtProvider;
import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public AuthUserDTO authenticate(@RequestBody AuthUserDTO authUserDTO) {
        authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(authUserDTO.getEmail(),
                authUserDTO.getPassword()));
        User user = userService.findByEmail(authUserDTO.getEmail());
        String token = jwtProvider.createToken(authUserDTO.getEmail(), user.getRoles());
        authUserDTO.setJwtToken(token);
        return authUserDTO;
    }
}
