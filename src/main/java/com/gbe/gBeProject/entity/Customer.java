package com.gbe.gBeProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
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

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    @jakarta.validation.constraints.Email
    private Email email;

    private Instant createdAt;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Order> orders;

    @ManyToMany

    @JoinTable(
            name = "customer_roles",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();
}
