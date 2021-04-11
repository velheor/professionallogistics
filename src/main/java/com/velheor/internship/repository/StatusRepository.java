package com.velheor.internship.repository;

import com.velheor.internship.models.Status;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, UUID> {

}
