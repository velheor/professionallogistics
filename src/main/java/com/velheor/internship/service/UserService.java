package com.velheor.internship.service;

import com.velheor.internship.models.Order;
import com.velheor.internship.models.User;
import com.velheor.internship.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void delete(User user) {
        if (!CollectionUtils.isEmpty(user.getOrders())) {
            for (Order order : user.getOrders()) {
                order.deleteUser(user);
            }
        }
        userRepository.delete(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(
                () -> new EntityNotFoundException("User with email: " + email + " was not found."));
    }
}
