package com.gbe.gBeProject.controller;

import com.gbe.gBeProject.entity.Customer;
import com.gbe.gBeProject.exception.UserNotFoundException;
import com.gbe.gBeProject.model.CustomerRequest;
import com.gbe.gBeProject.repository.CustomerRepository;
import com.gbe.gBeProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(path = "/{id}")
    Customer getCustomer(@PathVariable Long id) throws UserNotFoundException {
        return customerService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Customer saveCustomer(@RequestBody CustomerRequest customerRequest) {
        Customer customer = customerRequest.convert();
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping(path = "/{id}/delete")
    String deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return String.format("Customer with id %s is deleted", id);
    }
}
