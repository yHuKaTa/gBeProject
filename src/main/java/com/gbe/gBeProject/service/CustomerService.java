package com.gbe.gBeProject.service;

import com.gbe.gBeProject.entity.Customer;
import com.gbe.gBeProject.exception.UserNotFoundException;
import com.gbe.gBeProject.repository.CustomerRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Data
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

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
        newCustomer.setRoles(customer.getRoles());

        return newCustomer;
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
