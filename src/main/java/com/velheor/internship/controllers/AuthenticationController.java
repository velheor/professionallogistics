package com.velheor.internship.controllers;

import com.velheor.internship.dto.AuthUserDto;
import com.velheor.internship.dto.UserRegistrationDto;
import com.velheor.internship.mappers.RoleMapper;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.models.enums.EUserStatus;
import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    @PostMapping("/login")
    public String authenticate(@Valid @RequestBody AuthUserDto authUserDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authUserDTO.getEmail(),
                authUserDTO.getPassword());

        Collection<? extends GrantedAuthority> grantedAuthorityList
                = authenticationManager.authenticate(authenticationToken).getAuthorities();

        return userService.createWebToken(authUserDTO.getEmail(), roleMapper.toStringRoles(grantedAuthorityList));
    }

    @PostMapping("/signup")
    public void signUp(@Valid @RequestBody UserRegistrationDto userRegistrationDTO) {
        userService.registerUser(userMapper.toUser(userRegistrationDTO));
        userService.sendActivationCodeToEmail(userMapper.toUser(userRegistrationDTO));
    }

    @GetMapping("/activate/{code}")
    public void activateAccount(@PathVariable("code") String tokenMail) {
        userService.validateToken(tokenMail);
        userService.changeAccountStatusByEmail(EUserStatus.ACTIVE, userService.getEmailFromToken(tokenMail));
    }
}
