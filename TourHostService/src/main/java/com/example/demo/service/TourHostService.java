package com.example.demo.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.TourHost;
import com.example.demo.model.TourHostDetails;
import com.example.demo.repo.TourHostDetailsRepository;
import com.example.demo.repo.TourHostRepository;

@Service
public class TourHostService{
	@Autowired
	TourHostRepository hostRepo;
	
	@Autowired
	TourHostDetailsRepository detailsRepo;
	
	public List<TourHost> findAllTourHosts() {
        return hostRepo.findAll();
    }
	
    public TourHost findTourHost (int id) {
        return hostRepo.findByIdTourHost(Integer.valueOf(id));
    }
	
    /*public ResponseEntity<Object> removeTourHost(int id) {
    	TourHost host = hostRepo.findByIdTourHost(id);
    	if (host==null)
    		ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This tour host doesn't exist!");    	
    	hostRepo.delete(host);
    	TourHostDetails details = detailsRepo.findByTourHost(host);
    	if (details!=null)
    		detailsRepo.delete(details);    	
    	return ResponseEntity.status(HttpStatus.OK).body(true);
	}*/
    
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
        
        host.setPasswordTourHost(toMD5(host.getPasswordTourHost()));
        TourHost newHost = hostRepo.save(host);

        return ResponseEntity.status(HttpStatus.OK).body( newHost != null);
    }
    
	public String toMD5(String str){
        byte[] pass = null;
        
        try {
			pass = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		StringBuffer hexString = new StringBuffer();
		
		byte[] passHash = m.digest(pass);
		
		for (int i = 0; i < passHash.length; i++) {
		    if ((0xff & passHash[i]) < 0x10)
		        hexString.append("0" + Integer.toHexString((0xFF & passHash[i])));
		    else
		        hexString.append(Integer.toHexString(0xFF & passHash[i]));
		}		
		return hexString.toString();
   }
}
