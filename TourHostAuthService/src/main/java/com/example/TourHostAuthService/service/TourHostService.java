package com.example.TourHostAuthService.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TourHostAuthService.model.TourHost;
import com.example.TourHostAuthService.repository.TourHostRepository;

@Service
public class TourHostService{
	@Autowired
	TourHostRepository repository;   
    	
    public TourHost getByUsername(String username) {
    	TourHost k = repository.findByUsername(username);
    	return k;	
    }
}
