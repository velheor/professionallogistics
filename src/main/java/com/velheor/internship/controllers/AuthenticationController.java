package com.velheor.internship.controllers;

import com.velheor.internship.dto.AuthUserDTO;
import com.velheor.internship.dto.UserRegistrationDTO;
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
    public ResponseEntity<String> authenticate(@Valid @RequestBody AuthUserDTO authUserDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authUserDTO.getEmail(),
                authUserDTO.getPassword());

        Collection<? extends GrantedAuthority> grantedAuthorityList
                = authenticationManager.authenticate(authenticationToken).getAuthorities();

        return ResponseEntity.ok(userService.createWebToken(authUserDTO.getEmail(), roleMapper.mapToRoles(grantedAuthorityList)));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {

        userService.registerUser(userMapper.userRegistrationDtoToUser(userRegistrationDTO));
        userService.sendActivationCodeToEmail(userMapper.userRegistrationDtoToUser(userRegistrationDTO));

        return ResponseEntity.ok("Check your email!");
    }

    @GetMapping("/activate/{code}")
    public ResponseEntity<String> activateAccount(@PathVariable("code") String tokenMail) {
        userService.validateToken(tokenMail);
        userService.changeAccountStatusByEmail(EUserStatus.ACTIVE, userService.getEmailFromToken(tokenMail));
        return ResponseEntity.ok("Account activated successfully.");
    }
}
