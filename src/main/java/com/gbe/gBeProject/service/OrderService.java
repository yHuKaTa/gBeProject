package com.gbe.gBeProject.service;

import com.gbe.gBeProject.entity.Order;
import com.gbe.gBeProject.exception.UserNotFoundException;

public interface OrderService {
    Order createOrder(Order order, Long userId) throws UserNotFoundException;
}
