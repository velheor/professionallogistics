package com.velheor.internship.service;

import com.velheor.internship.email.EmailSender;
import com.velheor.internship.models.Role;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import com.velheor.internship.models.enums.EUserStatus;
import com.velheor.internship.repository.UserRepository;
import com.velheor.internship.security.JwtProvider;
import com.velheor.internship.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    private final UserValidator userValidator;

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "User with id: " + id + " was not found."));
    }

    @Transactional
    public User updateCurrentUser(String email, User userProfileUpdate) {
        User user = findByEmail(email);
        user.setFirstName(userProfileUpdate.getFirstName());
        user.setLastName(userProfileUpdate.getLastName());

        if (userValidator.checkForUserHasThisPhoneNumber(user.getId(), userProfileUpdate.getPhoneNumber())) {
            user.setPhoneNumber(userProfileUpdate.getPhoneNumber());
        }

        if (!passwordEncoder.matches(user.getPassword(), userProfileUpdate.getPassword())) {
            user.setPassword(passwordEncoder.encode(userProfileUpdate.getPassword()));
        }

        if (userValidator.checkForUserHasThisEmail(user.getId(), userProfileUpdate.getEmail())) {
            user.setEmail(userProfileUpdate.getEmail());
            user.setStatus(EUserStatus.INACTIVE);
            sendActivationCodeToEmail(user);
        }

        return user;
    }

    public User save(User user) {
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
