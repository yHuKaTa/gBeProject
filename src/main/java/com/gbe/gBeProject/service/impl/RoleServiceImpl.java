package com.gbe.gBeProject.service.impl;

import com.gbe.gBeProject.entity.Role;
import com.gbe.gBeProject.repository.RoleRepository;
import com.gbe.gBeProject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getByAuthority(String roleName) throws RoleNotFoundException {
        return roleRepository.findByAuthority(roleName).orElseThrow(RoleNotFoundException::new);
    }
}
