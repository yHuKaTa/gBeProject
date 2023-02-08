package com.gbe.gBeProject.repository;

import com.gbe.gBeProject.entity.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<Email,Long> {
}
