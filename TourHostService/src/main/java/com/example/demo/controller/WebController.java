package com.example.demo.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.TourHost;
import com.example.demo.repo.TourHostRepository;
import com.example.demo.service.TourHostService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping(path="/tourhost")
public class WebController {
	@Autowired
	TourHostRepository hostRepo;
	
	@Autowired
	TourHostService hostService;
	
	@RequestMapping("/save")
	public String process(){
		hostRepo.save(new TourHost("insider_sa", "34819d7beeabb9260a5c854bc85b3e44", "insider@sarajevo.ba", "Insider Sarajevo"));	
		hostRepo.save(new TourHost("myBosnia", "81c93a6d22daaa5fdb4dbd4267e5e06e", "mybosnia@gmail.com", "My Bosnia"));
		return null;
	}
		
	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public ResponseEntity<Object> findAll(){
		List<TourHost> allTourHosts = hostService.findAllTourHosts();

		if (allTourHosts.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No tour host has been found");
    	else	   						
    		return ResponseEntity.ok(allTourHosts);
	}	
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<Object> findTourHost(@RequestParam(name = "user") int id){
		TourHost tourHost = hostService.findTourHost(id);

		if (tourHost == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No tour host has been found");
    	else	   						
    		return ResponseEntity.ok(tourHost);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestParam(name = "username") String username, 
    		@RequestParam(name = "password") String pw, @RequestParam(name = "email") String email, 
    		@RequestParam(name = "name") String name)
    {
		TourHost host = new TourHost(username, pw, email, name);
        try {
        	return hostService.registerTourHost(host);
        } catch (ServiceException e){
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }
	
	/*@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public ResponseEntity<Object> removeTourHost(@RequestParam(name = "host") int id){
		TourHost host = hostRepo.findByIdTourHost(Integer.valueOf(id));
		if (host==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unknown tour host");
		}
		
		hostService.removeTourHost(Integer.valueOf(id));
		return ResponseEntity.ok(hostRepo.findByIdTourHost(Integer.valueOf(id))==null);
	}	*/
}