package com.gbe.gBeProject.controller;

import com.gbe.gBeProject.entity.Email;
import com.gbe.gBeProject.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/email")
public class EmailController {
    @Autowired
    EmailRepository emailRepository;
    @GetMapping(path = "/ifExists")
    public boolean getEmail(@RequestBody String email) {
        return emailRepository.existsByEmail(email);
    }
}
