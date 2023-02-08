package com.gbe.gBeProject.controller;

import com.gbe.gBeProject.entity.Customer;
import com.gbe.gBeProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(path = "/{id}")
    Customer getCustomer(@PathVariable Long id) {
        Customer customer = new Customer();
        Optional<Customer> customerResult = customerRepository.findById(id);
        if (customerResult.isPresent()){
            customer = customerResult.get();
        }
        return customer;
    }
}
