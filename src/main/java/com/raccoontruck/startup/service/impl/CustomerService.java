package com.raccoontruck.startup.service.impl;

import com.raccoontruck.startup.dto.CustomerDTO;
import com.raccoontruck.startup.models.Customer;
import com.raccoontruck.startup.repository.api.CustomerRepository;
import com.raccoontruck.startup.service.api.ICustomerService;
import com.raccoontruck.startup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return convertToDTO(customerRepository.findAll());
    }

    @Override
    public CustomerDTO findById(Long id) {
        if (!customerRepository.findById(id).isPresent()) {
            return null;
        }
        return convertToDTO(customerRepository.findById(id).orElse(null));
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CustomerDTO convertToDTO(Customer customer) {
        return ObjectMapperUtils.map(customer, CustomerDTO.class);
    }

    @Override
    public Customer convertFromDTO(CustomerDTO customerDTO) {
        return ObjectMapperUtils.map(customerDTO, Customer.class);
    }

    @Override
    public List<CustomerDTO> convertToDTO(List<Customer> customers) {
        return ObjectMapperUtils.mapAll(customers, CustomerDTO.class);
    }

    @Override
    public List<Customer> convertFromDTO(List<CustomerDTO> customerDTOS) {
        return ObjectMapperUtils.mapAll(customerDTOS, Customer.class);
    }
}