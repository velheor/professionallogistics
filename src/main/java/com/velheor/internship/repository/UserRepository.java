package com.velheor.internship.repository;

import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.EUserStatus;
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
    @Query("UPDATE User user SET user.status = ?1 WHERE user.email = ?2")
    void changeAccountStatusByEmail(EUserStatus status, String email);

    @Query("SELECT (COUNT(user) = 0) FROM User user WHERE user.email = ?1")
    Boolean checkForUniqueEmail(String email);

    @Query("SELECT (COUNT(user) = 0) FROM User user WHERE user.phoneNumber = ?1")
    Boolean checkForUniquePhoneNumber(String phoneNumber);

    @Query("SELECT (COUNT(user) = 1) FROM User user WHERE user.id = ?1 AND user.email = ?2")
    Boolean checkForUserHasThisEmail(UUID id, String email);

    @Query("SELECT (COUNT(user) = 1) FROM User user WHERE user.id = ?1 AND user.phoneNumber = ?2")
    Boolean checkForUserHasThisPhoneNumber(UUID id, String phoneNumber);
}
