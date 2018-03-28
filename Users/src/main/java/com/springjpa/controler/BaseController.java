package com.springjpa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.User;
import com.springjpa.repository.UserRepository;

@RestController
public class BaseController {
	
	@Autowired
	UserRepository userRepo;

	
	@RequestMapping("/saveRoles")
	public String process(){
		
		return "Done";
	}
	
	@RequestMapping("/saveUser")
	public String saveAdmin(){
		
		char [] list = null;
		User user = new User("dummyUser", "Test1234", "elzaa_95@hotmail.com", "Elza", "Kalac", 
				"066020564", list , "BiH") ;
		userRepo.save(user);
		return "";
	}
}