package com.gbe.gBeProject.model;

import com.gbe.gBeProject.entity.Customer;
import com.gbe.gBeProject.entity.Email;
import com.gbe.gBeProject.entity.Role;
import com.gbe.gBeProject.service.impl.RoleServiceImpl;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleNotFoundException;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Getter
@Component
public class CustomerRequest implements Serializable {
    private static RoleServiceImpl roleService;

    @Autowired
    public CustomerRequest(RoleServiceImpl roleService) {
        CustomerRequest.roleService = roleService;
    }
    @NotNull(message = "Name couldn't be null")
    @Size(min = 3, max = 50, message = "Name shoud be between 3 and 50 characters")
    private String name;
    private String lastName;
    @jakarta.validation.constraints.Email
    private String email;
    private String password;
    private Set<String> userRoles = Objects.requireNonNullElseGet(this.userRoles, HashSet::new);

    public Customer convert() {
        return Customer.builder()
                .customerName(this.name)
                .customerLastName(this.lastName)
                .email(new Email(this.email))
                .createdAt(Instant.now())
                .orders(new HashSet<>())
                .userRoles(setUserRoles(this.getUserRoles()))
                .build();
    }

    Set<Role> setUserRoles(Set<String> userRoles) {
        Set<Role> checkedRoles = new HashSet<>();

        userRoles.forEach(userRole -> {
        try {
            Role newRole = roleService.getByAuthority(userRole);
            checkedRoles.add(newRole);
        } catch (RoleNotFoundException e) {
            throw new RuntimeException(e);
        }
        });
        return checkedRoles;
    }

}
