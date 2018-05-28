package com.springjpa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springjpa.model.User;
import com.springjpa.repository.UserRepository;
import com.springjpa.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService korisnikService;
	
	@Autowired
	private UserRepository userRepo;

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@RequestParam("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(korisnikService.getUserById(id));
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, value="/")
	public ResponseEntity<?> getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAll());
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		if (user == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Potrebno je poslati podatke user-a");

		return korisnikService.saveUser(user.getUsername(), user.getPasswordHash(), user.getEmail(),
				user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getImage(), user.getCountry(), user.getRole());
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestParam("id") Integer id) {
		return korisnikService.deleteUserById(id);
	}

}
