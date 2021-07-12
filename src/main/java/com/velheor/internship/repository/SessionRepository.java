package com.velheor.internship.repository;

import com.velheor.internship.models.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface SessionRepository extends CrudRepository<Session, UUID> {
    Optional<Session> findByRefreshToken(String refreshToken);
}
