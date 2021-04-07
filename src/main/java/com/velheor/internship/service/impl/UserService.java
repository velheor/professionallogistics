package com.velheor.internship.service.impl;

import com.velheor.internship.models.Order;
import com.velheor.internship.models.User;
import com.velheor.internship.repository.UserRepository;
import com.velheor.internship.service.api.IUserService;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException(
                    "User with id: " + id.toString() + " was not found."));
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User user) {
        if (user.getOrders() != null) {
            for (Order order : user.getOrders()) {
                order.deleteUser(user);
            }
        }
        userRepository.delete(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(
                () -> new EntityNotFoundException("User with email: " + email + " was not found."));
    }
}
