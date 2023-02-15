package com.gbe.gBeProject.controller;

import com.gbe.gBeProject.entity.Order;
import com.gbe.gBeProject.exception.UserNotFoundException;
import com.gbe.gBeProject.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @PostMapping (path = "/create")
    public Order createOrder(@RequestBody Order order, @RequestParam Long userId) throws UserNotFoundException {
        return orderService.createOrder(order, userId);
    }
}
