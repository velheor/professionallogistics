package com.velheor.internship.service;

import com.velheor.internship.models.Role;
import com.velheor.internship.repository.RoleRepository;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findById(UUID id) {
        return roleRepository.findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException(
                    "Role with id: " + id.toString() + " was not found."));
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Iterable<Role> getAll() {
        return roleRepository.findAll();
    }

    public void deleteById(UUID id) {
        roleRepository.deleteById(id);
    }
}
