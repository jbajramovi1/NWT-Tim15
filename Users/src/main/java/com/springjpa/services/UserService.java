package com.springjpa.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.amqp.core.TopicExchange;
import com.springjpa.model.User;
import com.springjpa.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	private final RabbitTemplate rabbitTemplate;
	private final TopicExchange exchange;

	@Autowired
	public UserService(RabbitTemplate rabbitTemplate, TopicExchange exchange) {
	    this.rabbitTemplate = rabbitTemplate;
	    this.exchange = exchange;
	}
	public ResponseEntity<?> saveUser(
			String username, 
			String password, 
			String email, 
			String firstName, 
			String lastName,
			String phoneNumber, 
			char[] image, 
			String country) {

		User user;
		try {
			user = new User(username, password, email, firstName, lastName, phoneNumber, image, country);
			repository.save(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		}

		return ResponseEntity.ok(user);
	}

	public ResponseEntity<?> getUserById(Integer id) {
		User user = repository.findByIdKorisnika(id);
		if (user != null)
			return ResponseEntity.ok(user);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ne postoji user sa datim id");
	}

	public ResponseEntity<?> deleteUserById(Integer id) {
		User user = repository.findByIdKorisnika(id);
		if (user != null) {
			repository.delete(id);
		    String routingKey = "user.deleted";
		    String message = "user deleted";
		    rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);
			return ResponseEntity.ok(user);

		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ne postoji user sa datim id");
	}
}
