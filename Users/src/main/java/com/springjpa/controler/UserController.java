package com.springjpa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService korisnikService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@RequestParam("id") Integer id) {
		return korisnikService.getUserById(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		if (user == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Potrebno je poslati podatke user-a");

		return korisnikService.saveUser(user.getUsername(), user.getPasswordHash(), user.getEmail(),
				user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getImage(), user.getCountry());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> deleteUser(@RequestParam("id") Integer id) {
		return korisnikService.deleteUserById(id);
	}

}
