package com.springjpa.controller;
 
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springjpa.model.TourHost;
import com.springjpa.model.User;
import com.springjpa.model.Recommendation;
import com.springjpa.repo.TourHostRepository;
import com.springjpa.services.TourHostService;
import com.springjpa.services.UserService;
import com.springjpa.services.RecommendationService;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
 
@RestController
public class WebController {
	@Autowired
	TourHostRepository hostRepo;
	
	@Autowired
	TourHostService hostService;
	
	@Autowired
	RecommendationService recomService;
	
	@Autowired
	UserService userService;
	
    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate; 

    protected String serviceUrl = "http://ZUULAPIGATEWAY";

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/addrecommendation", method = RequestMethod.GET)
	public ResponseEntity<Object> addRecommendation(@RequestHeader("Authorization") String token, @RequestHeader("Roles") String role, @RequestParam(name = "user") int user, @RequestParam(name = "host") int host) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Authorization", token);
	    headers.set("Roles", role);
	    HttpEntity<String> entity = new HttpEntity<String>(headers); 
	    		
		try {
	    	ResponseEntity<User> response = restTemplate.exchange(serviceUrl + "/user-service/user?id={user}",  HttpMethod.GET, entity, User.class, user);
	    			
			userService.checkUser(response.getBody(), user);
			User myUser = userService.findUser(user);  
		    
		    TourHost tourHost = hostService.findTourHost(host); 	        
	
		    Recommendation recommendation = new Recommendation(tourHost, myUser);

	        recomService.registerRecommendation(recommendation);
	        	      	
		    return ResponseEntity.ok(recommendation);	       
	        
	    } catch (ServiceException e){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error!");
        }
	  }

	@CrossOrigin(origins = "*")
	@RequestMapping("/save")
	public String process(){
		hostRepo.save(new TourHost("insider_sa", "test", "insider@sarajevo.ba", "Insider Sarajevo", ""));	
		hostRepo.save(new TourHost("myBosnia", "test", "mybosnia@gmail.com", "My Bosnia", ""));
		return null;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public ResponseEntity<Object> findAll(){
		List<TourHost> allTourHosts = hostService.findAllTourHosts();

		if (allTourHosts.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No tour host has been found");
    	else	   						
    		return ResponseEntity.ok(allTourHosts);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<Object> findTourHost(@RequestParam(name = "user") int id){
		TourHost tourHost = hostService.findTourHost(id);

		if (tourHost == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No tour host has been found");
    	else	   						
    		return ResponseEntity.ok(tourHost);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody TourHost tourHost)
    {
		if (tourHost == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing information");
        try {
        	return hostService.registerTourHost(tourHost);
        } catch (ServiceException e){
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public ResponseEntity<Object> removeTourHost(@RequestParam(name = "host") int id){
		TourHost host = hostRepo.findByIdTourHost(Integer.valueOf(id));
		if (host==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unknown tour host");
		}
		
		hostService.removeTourHost(Integer.valueOf(id));
		return ResponseEntity.ok(hostRepo.findByIdTourHost(Integer.valueOf(id))==null);
	}
	
}