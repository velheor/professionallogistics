package com.raccoontruck.startup;

import com.raccoontruck.startup.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/auth/")
public class AuthenticationRestController {
    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody AuthenticationRequestDTO authRequestDTO) {
        try {
            String email = authRequestDTO.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, authRequestDTO.getPassword()));

            UserDTO user = userService.findByEmail(email);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + email + " not found");
            }

            authRequestDTO.setToken(jwtTokenProvider.createTokenFromDTO(email, user.getRoles()));

            return "registration";
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password" + e.getMessage());
        }
    }

    @PutMapping("/registration")
    public String createAccount(@RequestBody UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userService.update(userDTO);
        return "registration";
    }
}