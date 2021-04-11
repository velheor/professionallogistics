package com.velheor.internship.repository;

import com.velheor.internship.models.Load;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface LoadRepository extends CrudRepository<Load, UUID> {

}
