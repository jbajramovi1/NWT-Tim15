package com.springjpa.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springjpa.model.TourHost;
import com.springjpa.model.TourHostDetails;
import com.springjpa.repo.TourHostDetailsRepository;
import com.springjpa.repo.TourHostRepository;

@Service
public class TourHostService{
	@Autowired
	TourHostRepository hostRepo;
	
	@Autowired
	TourHostDetailsRepository detailsRepo;
	
    @Autowired       
    @LoadBalanced     
    protected RestTemplate restTemplate; 

    protected String serviceUrl;
    
    public TourHostService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ?
               serviceUrl : "http://" + serviceUrl;
    }
	
	public List<TourHost> findAllTourHosts() {
        return hostRepo.findAll();
    }
	
    public TourHost findTourHost (int id) {
        return hostRepo.findByIdTourHost(Integer.valueOf(id));
    }

	public TourHost findTourHostByUsername (String username) {
		return hostRepo.findByUsernameTourHost(username);
	}
	
    public ResponseEntity<Object> removeTourHost(int id) {
    	TourHost host = hostRepo.findByIdTourHost(id);
    	if (host==null)
    		ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This tour host doesn't exist!");    	
    	hostRepo.delete(host);
    	TourHostDetails details = detailsRepo.findByTourHost(host);
    	if (details!=null)
    		detailsRepo.delete(details);    	
    	return ResponseEntity.status(HttpStatus.OK).body(true);
	}
    
    public ResponseEntity<Object> registerTourHost(TourHost host) {        
        if (host.getUsernameTourHost()=="")
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please insert username");
    	else if (hostRepo.findByUsernameTourHost(host.getUsernameTourHost())!=null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This username already exists");
    	else if (host.getPasswordTourHost()=="")
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please insert password");
    	else if (host.getEmailTourHost()=="")
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please insert email");
    	else if (host.getNameTourHost()=="")
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please insert tour host name");

        TourHost newHost = hostRepo.save(host);

        return ResponseEntity.status(HttpStatus.OK).body( newHost != null);
    }
}
