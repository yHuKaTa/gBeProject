package com.gbe.gBeProject.repository;

import com.gbe.gBeProject.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByAuthority(String roleName);
}
