package com.velheor.internship.repository;

import com.velheor.internship.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {

}
