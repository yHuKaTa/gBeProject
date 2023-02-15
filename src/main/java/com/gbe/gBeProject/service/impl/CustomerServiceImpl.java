package com.gbe.gBeProject.service.impl;

import com.gbe.gBeProject.entity.Customer;
import com.gbe.gBeProject.exception.UserNotFoundException;
import com.gbe.gBeProject.repository.CustomerRepository;
import com.gbe.gBeProject.service.CustomerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Customer findById(Long id) throws UserNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new UserNotFoundException(String.format("User with id %s not found", id));
        }
    }

    public Customer saveCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName(customer.getCustomerName());
        newCustomer.setCustomerLastName(customer.getCustomerLastName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setOrders(customer.getOrders());
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        newCustomer.setPassword(customer.getPassword());
//        newCustomer.setRoles(customer.getRoles());

        return newCustomer;
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
