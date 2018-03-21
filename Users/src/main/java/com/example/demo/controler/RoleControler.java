package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@RestController
public class RoleControler {

	/*@Autowired
	RoleRepository userRepo;  */
	
	@RequestMapping(value = "/add")
    public String register()
    {
		//userRepo.save(new Role("Admin"));
         return "Done";
    } 
    }
