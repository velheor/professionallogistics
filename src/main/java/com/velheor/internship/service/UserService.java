package com.velheor.internship.service;

import com.velheor.internship.dto.TruckViewDTO;
import com.velheor.internship.dto.UserWithTruckDTO;
import com.velheor.internship.models.Role;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import com.velheor.internship.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "User with id: " + id + " was not found."));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role defaultRole = new Role();
        defaultRole.setName(ERole.SHIPPER);
        user.setRoles(Collections.singletonList(defaultRole));
        return userRepository.save(user);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException(
                "User with email: " + email + " was not found."));
    }

    @Transactional
    public void changeAccountStatusByEmail(Boolean isActive, String email) {
        userRepository.activateUserByEmail(isActive, email);
    }

    public void saveAll(Iterable<User> users) {
        userRepository.saveAll(users);
    }
}
