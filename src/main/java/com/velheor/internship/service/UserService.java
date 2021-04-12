package com.velheor.internship.service;

import com.velheor.internship.models.User;
import com.velheor.internship.repository.UserRepository;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(UUID id) {
        return userRepository.findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException(
                    "User with id: " + id.toString() + " was not found."));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(
                () -> new EntityNotFoundException("User with email: " + email + " was not found."));
    }
}
