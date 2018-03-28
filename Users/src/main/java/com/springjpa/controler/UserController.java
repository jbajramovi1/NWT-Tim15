package com.springjpa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.User;
import com.springjpa.services.UserService;

@RestController
@CrossOrigin
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
    private UserService korisnikService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@RequestParam("id") Integer id) {		
		return korisnikService.getUserById(id);
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		return korisnikService.saveUser(user.getUsername(), user.getPasswordHash(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getImage(), user.getCountry());
	}

}
