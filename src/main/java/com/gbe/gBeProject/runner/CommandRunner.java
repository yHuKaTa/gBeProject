package com.gbe.gBeProject.runner;

import com.gbe.gBeProject.entity.Customer;
import com.gbe.gBeProject.entity.Email;
import com.gbe.gBeProject.entity.Order;
import com.gbe.gBeProject.entity.Product;
import com.gbe.gBeProject.repository.CustomerRepository;
import com.gbe.gBeProject.repository.EmailRepository;
import com.gbe.gBeProject.repository.OrderRepository;
import com.gbe.gBeProject.repository.ProductRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmailRepository emailRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        Email email = new Email();
        email.setEmailAddress("aaa@bbb.gg");
        emailRepository.save(email);

        Customer customer = new Customer();
        customer.setCustomerName("Petkan");
        customer.setCustomerLastName("Mladenov");
        customer.setEmail(email);

        customerRepository.save(customer);

        Product potato = new Product();
        potato.setProduct("Potato");
        productRepository.save(potato);
        Product tomato = new Product();
        tomato.setProduct("Tomato");
        productRepository.save(tomato);
        Product tomato1 = new Product();
        tomato1.setProduct("Tomato");
        productRepository.save(tomato1);
        Product onion = new Product();
        onion.setProduct("Onion");
        productRepository.save(onion);
        Product onion1 = new Product();
        onion1.setProduct("Onion");
        productRepository.save(onion1);

        Order order = new Order();
        order.setProducts(Set.of(potato,tomato,onion));
        order.setCustomer(customer);
        Order order1 = new Order();
        order1.setProducts(Set.of(tomato1,onion1));
        order1.setCustomer(customer);
        orderRepository.save(order);
        orderRepository.save(order1);
        Set<Order> orders = Set.of(order,order1);
        customer.setOrders(orders);
        customerRepository.save(customer);
    }
}
