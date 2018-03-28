package com.springjpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springjpa.model.User;
import com.springjpa.repository.UserRepository;
 
@Service
public class UserService {
	
    @Autowired
    UserRepository repository;   
    
    public ResponseEntity<?> saveUser(String username, String password, String email, String firstName, String lastName,
			String phoneNumber, char[] image, String country) {
    	User user = new User(username, password, email, firstName, lastName,
				phoneNumber, image, country);
   
    	
    	repository.save(user);	
    	
    	return repository.save(user);	

    }
    
    public ResponseEntity<?> getUserById(Integer id) {
    	User user = repository.findByIdKorisnika(id);
    	if (user != null)
    		return ResponseEntity.ok(user);
    	else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ne postoji user sa datim id");
    	}   
}
