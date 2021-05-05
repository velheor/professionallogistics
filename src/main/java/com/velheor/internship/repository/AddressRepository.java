package com.velheor.internship.repository;

import com.velheor.internship.models.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<Address, UUID> {

}
