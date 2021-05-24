package com.velheor.internship.service;

import com.velheor.internship.dto.UserProfileUpdateDTO;
import com.velheor.internship.email.EmailSender;
import com.velheor.internship.models.Role;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import com.velheor.internship.models.enums.EUserStatus;
import com.velheor.internship.repository.UserRepository;
import com.velheor.internship.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final EmailSender emailSender;

    private final JwtProvider jwtProvider;

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "User with id: " + id + " was not found."));
    }

    public void updateCurrentUser(Principal principal, UserProfileUpdateDTO userProfileUpdateDTO) {
        User user = findByEmail(principal.getName());
        if (StringUtils.hasText(userProfileUpdateDTO.getFirstName())) {
            user.setFirstName(userProfileUpdateDTO.getFirstName());
        }

        if (StringUtils.hasText(userProfileUpdateDTO.getLastName())) {
            user.setLastName(userProfileUpdateDTO.getLastName());
        }

        if (StringUtils.hasText(userProfileUpdateDTO.getPhoneNumber())) {
            user.setPhoneNumber(userProfileUpdateDTO.getPhoneNumber());
        }

        if (StringUtils.hasText(userProfileUpdateDTO.getPassword())) {
            user.setPassword(userProfileUpdateDTO.getPassword());
        }

        if (StringUtils.hasText(userProfileUpdateDTO.getEmail())) {
            user.setEmail(userProfileUpdateDTO.getEmail());
            user.setStatus(EUserStatus.INACTIVE);
            String token = jwtProvider.createMailToken(user.getEmail());
            emailSender.sendMessageAfterChangeEmail(user.getEmail(), token);
        }

        save(user);
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException(
                "User with email: " + email + " was not found."));
    }

    public User registerUser(User user) {
        Role defaultRole = new Role();
        defaultRole.setName(ERole.SHIPPER);
        defaultRole.setUser(user);
        user.setRoles(Collections.singletonList(defaultRole));
        return save(user);
    }

    public void sendActivationCodeToEmail(User user) {
        String token = jwtProvider.createMailToken(user.getEmail());
        emailSender.sendMessageAfterSignUp(user, token);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void changeAccountStatusByEmail(EUserStatus userStatus, String email) {
        userRepository.changeAccountStatusByEmail(userStatus, email);
    }

    public void saveAll(Iterable<User> users) {
        userRepository.saveAll(users);
    }

    public String createWebToken(String email, List<String> roles) {
        return jwtProvider.createWebToken(email, roles);
    }

    public void validateToken(String token) {
        jwtProvider.validateToken(token);
    }

    public String getEmailFromToken(String tokenMail) {
        return jwtProvider.getEmail(tokenMail);
    }
}
