package com.gbe.gBeProject.model;

import com.gbe.gBeProject.entity.Customer;
import com.gbe.gBeProject.entity.Email;
import com.gbe.gBeProject.entity.Role;
import lombok.Getter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
public class CustomerRequest {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Set<Role> roles;

    public Customer convert() {
        return Customer.builder()
                .customerName(this.name)
                .customerLastName(this.lastName)
                .email(new Email(this.email))
                .createdAt(Instant.now())
                .orders(new HashSet<>())
                .roles(new HashSet<>())
                .build();
    }

}
