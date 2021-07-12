package com.velheor.internship.controllers;

import com.velheor.internship.dto.AuthUserDto;
import com.velheor.internship.dto.JwtResponse;
import com.velheor.internship.dto.UserRegistrationDto;
import com.velheor.internship.exception.JwtAuthenticationException;
import com.velheor.internship.mappers.RoleMapper;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.models.Role;
import com.velheor.internship.models.Session;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.EUserStatus;
import com.velheor.internship.security.JwtProvider;
import com.velheor.internship.service.SessionService;
import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final SessionService sessionService;
    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@Valid @RequestBody AuthUserDto authUserDTO, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authUserDTO.getEmail(),
                authUserDTO.getPassword());

        Collection<? extends GrantedAuthority> grantedAuthorityList
                = authenticationManager.authenticate(authenticationToken).getAuthorities();

        String accessToken = userService.createWebToken(authUserDTO.getEmail(), roleMapper.toStringRoles(grantedAuthorityList));
        String refreshToken = sessionService.createRefreshToken(request, authUserDTO);
        return ResponseEntity.ok(new JwtResponse(accessToken, refreshToken));
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

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshToken(@NotBlank @RequestBody String requestRefreshToken) {
        if (jwtProvider.validateToken(requestRefreshToken)) {
            throw new JwtAuthenticationException();
        }

        Session session = sessionService.findByRefreshToken(requestRefreshToken);
        User user = session.getUser();
        List<Role> roles = user.getRoles();
        String refreshToken = jwtProvider.createRefreshToken();
        String accessToken = userService.createWebToken(user.getEmail(), roleMapper.toStringRoles(roles));
        return ResponseEntity.ok(new JwtResponse(accessToken, refreshToken));
    }
}
