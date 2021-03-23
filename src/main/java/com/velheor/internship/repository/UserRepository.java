package com.velheor.internship.repository;

import com.velheor.internship.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
