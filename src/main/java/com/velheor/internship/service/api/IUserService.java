package com.velheor.internship.service.api;

import com.velheor.internship.models.User;
import java.util.UUID;

public interface IUserService extends Crud<User> {

    User findById(UUID id);

    User findByEmail(String email);
}
