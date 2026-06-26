package com.CustomerManagement.CRUD.service;

import com.CustomerManagement.CRUD.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
    List<Customer> getAllCustomer();
    Optional<Customer> getById(Long id);
    Customer updateCustomer(Customer customer, Long id);
    String  deleteCustomer(Long id);

    Customer createCustomer(Customer customer);
}
