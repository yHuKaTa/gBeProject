package com.gbe.gBeProject.runner;

import com.gbe.gBeProject.entity.*;
import com.gbe.gBeProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Email email = new Email();
        email.setEmail("aaa@bbb.gg");
        emailRepository.save(email);

        Customer customer = new Customer();
        customer.setCustomerName("Petkan");
        customer.setCustomerLastName("Mladenov");
        customer.setEmail(email);



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

        Set<Order> orders = Set.of(order,order1);
        customer.setOrders(orders);

        Role role = new Role();
        role.setAuthority("VIP");
        Role role1 = new Role();
        role1.setAuthority("Standart");

//        role.setCustomers(Set.of(customer));
//        role1.setCustomers(Set.of(customer));

        roleRepository.save(role);
        roleRepository.save(role1);

        customer.setUserRoles(Set.of(role,role1));
        customerRepository.save(customer);

        orderRepository.save(order);
        orderRepository.save(order1);


    }
}
