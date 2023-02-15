package com.gbe.gBeProject.service.impl;

import com.gbe.gBeProject.entity.Customer;
import com.gbe.gBeProject.entity.Order;
import com.gbe.gBeProject.exception.UserNotFoundException;
import com.gbe.gBeProject.repository.OrderRepository;
import com.gbe.gBeProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final CustomerServiceImpl customerService;
    private final OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CustomerServiceImpl customerService) {
        this.customerService = customerService;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order, Long userId) throws UserNotFoundException {
        Customer customer = customerService.findById(userId);
        order.setCustomer(customer);
        return orderRepository.save(order);
    }
}
