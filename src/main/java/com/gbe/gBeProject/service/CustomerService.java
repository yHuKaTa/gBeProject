package com.gbe.gBeProject.service;

import com.gbe.gBeProject.entity.Customer;
import com.gbe.gBeProject.exception.UserNotFoundException;

public interface CustomerService {
    Customer findById(Long id) throws UserNotFoundException;
    Customer saveCustomer(Customer customer);
    void deleteById(Long id);
}
