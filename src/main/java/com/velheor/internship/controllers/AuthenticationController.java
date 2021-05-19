package com.velheor.internship.controllers;

import com.velheor.internship.dto.AuthUserDTO;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.email.EmailSender;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.security.JwtProvider;
import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
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
    private final JwtProvider jwtProvider;
    private final EmailSender emailSender;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@Valid @RequestBody AuthUserDTO authUserDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authUserDTO.getEmail(),
                authUserDTO.getPassword());

        Collection<? extends GrantedAuthority> grantedAuthorityList
                = authenticationManager.authenticate(authenticationToken).getAuthorities();

        return ResponseEntity.ok(jwtProvider.createWebToken(authUserDTO.getEmail(), grantedAuthorityList));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody UserViewDTO userViewDTO) {
        userService.save(userMapper.userDtoToUser(userViewDTO));

        String token = jwtProvider.createMailToken(userViewDTO.getEmail());

        emailSender.sendMessageAfterSignUp(userViewDTO, token);
        return ResponseEntity.ok("Check your email!");
    }

    @PostMapping("/activate/{code}")
    public ResponseEntity<String> activateAccount(@PathVariable("code") String tokenMail) {
        jwtProvider.validateToken(tokenMail);
        userService.changeAccountStatusByEmail(true, jwtProvider.getEmail(tokenMail));
        return ResponseEntity.ok("Account activated successfully.");
    }
}
