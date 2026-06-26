package com.CustomerManagement.CRUD.service;

import com.CustomerManagement.CRUD.model.Customer;
import com.CustomerManagement.CRUD.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }


    @Override
    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer updateCustomer(Customer customerDetails, Long id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer with Customer Id " + id + " not found"));

        if (customerDetails.getFirstName() != null) {
            existingCustomer.setFirstName(customerDetails.getFirstName());
        }
        if(customerDetails.getLastName()!=null){
            existingCustomer.setLastName(customerDetails.getLastName());
        }

        if(customerDetails.getPhoneNumber()!=null){
            existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        }
        if (customerDetails.getEmail() != null) {
            existingCustomer.setEmail(customerDetails.getEmail());
        }

        return customerRepository.save(existingCustomer);
    }

    @Override
    public String deleteCustomer(Long id) {
        Customer savedCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with Customer Id " + id + " not found"));
        customerRepository.delete(savedCustomer);
        return "Customer deleted";
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


}
