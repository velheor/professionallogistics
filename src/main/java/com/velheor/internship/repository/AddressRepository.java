package com.velheor.internship.repository;

import com.velheor.internship.models.Address;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, UUID> {

}
