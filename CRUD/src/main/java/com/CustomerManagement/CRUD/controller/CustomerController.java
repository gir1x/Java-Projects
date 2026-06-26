package com.CustomerManagement.CRUD.controller;


import com.CustomerManagement.CRUD.model.Customer;
import com.CustomerManagement.CRUD.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customer = customerService.getAllCustomer();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getById(id);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer created = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/customers/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        try {
            customerService.updateCustomer(customer,id);
            return new ResponseEntity<>("Customer with Customer Id " + id + " updated", HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        try {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }
    }

}
