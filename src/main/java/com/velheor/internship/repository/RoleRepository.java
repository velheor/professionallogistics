package com.velheor.internship.repository;

import com.velheor.internship.models.Role;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, UUID> {

}
