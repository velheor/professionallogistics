package com.velheor.internship.repository;

import com.velheor.internship.models.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StatusRepository extends CrudRepository<Status, UUID> {

}
