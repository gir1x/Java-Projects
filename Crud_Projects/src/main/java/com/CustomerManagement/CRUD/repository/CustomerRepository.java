package com.CustomerManagement.CRUD.repository;

import com.CustomerManagement.CRUD.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
