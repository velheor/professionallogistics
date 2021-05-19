package com.velheor.internship.repository;

import com.velheor.internship.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    @EntityGraph(value = "UserWithRoles")
    Optional<User> findByEmail(String email);

    @Modifying
    @Query(value = "UPDATE User user SET user.isActive = ?1 WHERE user.email = ?2")
    void activateUserByEmail(Boolean isActive, String email);
}
