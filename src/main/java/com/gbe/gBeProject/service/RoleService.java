package com.gbe.gBeProject.service;


import com.gbe.gBeProject.entity.Role;

import javax.management.relation.RoleNotFoundException;

public interface RoleService {
    Role getByAuthority(String roleName) throws RoleNotFoundException;
}
