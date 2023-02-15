package com.gbe.gBeProject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "customers")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

//    @Min(3)
//    @Max(50)
    @Column(name = "customer_name",length = 50)
    private String customerName;

//    @Min(3)
//    @Max(50)
    @Column(name = "customer_last_name", length = 50)
    private String customerLastName;

    private String password;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private Email email;

    private Instant createdAt;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Order> orders = Objects.requireNonNullElseGet(this.orders, HashSet::new);

    @ManyToMany (fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_role_id")}
    )
    private Set<Role> userRoles = Objects.requireNonNullElseGet(this.userRoles, HashSet::new);
}
