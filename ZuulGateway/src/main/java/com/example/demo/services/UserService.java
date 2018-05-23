package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService{

	@Autowired
	UserRepository repository;   
    	
    public com.example.demo.model.User getByUsername(String username) {
    	com.example.demo.model.User k = repository.findByUsername(username);
    	return k;	
    }
}
