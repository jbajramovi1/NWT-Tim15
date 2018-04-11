package com.springjpa.services;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.springjpa.model.Recommendation;
import com.springjpa.model.TourHost;
import com.springjpa.model.User;
import com.springjpa.repo.TourHostRecommendationRepository;
import com.springjpa.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
    public ResponseEntity<Object> registerUser(User user) {       
    	User newU = userRepo.save(user);
        return ResponseEntity.status(HttpStatus.OK).body( newU != null);
    }
    
	public User findUser (int id) {
        return userRepo.findByIdKorisnika(id);
    }
	
	public ResponseEntity<Object> checkUser(User response, int id) {
	    try {			    	  
		    response.setIdUser(id);
		    
		    User check = userRepo.findByIdKorisnika(id);
		    if (check == null)
		    	this.registerUser(response);		    
		     	        
		    return ResponseEntity.ok(response);
	    } catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
	  }
}
