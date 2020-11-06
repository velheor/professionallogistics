package com.raccoontruck.startup.repository.api;

import com.raccoontruck.startup.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}