package com.example.UserAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.UserAuth.repository.UserRepository;
import com.example.UserAuth.model.User;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService{

	@Autowired
	UserRepository repository;   
    	
    public User getByUsername(String username) {
    	User k = repository.findByUsername(username);
    	return k;	
    }
}
