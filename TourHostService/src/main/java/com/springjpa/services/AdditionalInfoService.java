package com.springjpa.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springjpa.model.TourHost;
import com.springjpa.model.TourHostDetails;
import com.springjpa.model.TourHostExternalLink;
import com.springjpa.model.TourHostLocation;
import com.springjpa.model.TourHostPaymentInfo;
import com.springjpa.repo.TourHostDetailsRepository;
import com.springjpa.repo.TourHostExternalLinkRepository;
import com.springjpa.repo.TourHostLocationRepository;
import com.springjpa.repo.TourHostPaymentInfoRepository;
import com.springjpa.repo.TourHostRepository;

@Service
public class AdditionalInfoService {

	@Autowired
	TourHostRepository hostRepo;	
	@Autowired
	TourHostDetailsRepository detailsRepo;
	@Autowired
	TourHostExternalLinkRepository linksRepo;
	@Autowired
	TourHostPaymentInfoRepository paymentRepo;
	@Autowired
	TourHostLocationRepository locationRepo;
	
	/*---> ExternalLink*/
	
	public Iterable<TourHostExternalLink> findExternalLinksByTourHosts(TourHost host) {
        return linksRepo.findByTourHost(host);
    }
	
    public TourHostExternalLink findExternalLink (int id) {
        return linksRepo.findById(Integer.valueOf(id));
    }
    
    public ResponseEntity<Object> removeExternalLink(int id) {
    	TourHostExternalLink myLink = linksRepo.findById(id);
    	if (myLink==null)
    		ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This external link doesn't exist!");    	
    	linksRepo.delete(myLink);    	
    	return ResponseEntity.status(HttpStatus.OK).body(true);
	}
    
    public ResponseEntity<Object> removeExternalLinkByHost(TourHost host) {
    	Iterable<TourHostExternalLink> myLinks = linksRepo.findByTourHost(host);
    	if (myLinks==null)
    		ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No external links were found!");    	
    	for (TourHostExternalLink myLink : myLinks) {
    		linksRepo.delete(myLink);
    	}    	    	
    	return ResponseEntity.status(HttpStatus.OK).body(true);
	}
    
    public ResponseEntity<Object> addExternalLink(TourHostExternalLink myLink) {        
        if (myLink.getTourHost()==null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unknown tour host");
    	else if (hostRepo.findByUsernameTourHost(myLink.getTourHost().getUsernameTourHost())==null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unknown tour host");
    	else if (myLink.getExternalLink()=="")
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please insert external link");
    	else if (myLink.getExternalLinkType()=="")
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please choose external link's type");
    	else if (linksRepo.findByExternalLink(myLink.getExternalLink()) != null)
        linksRepo.save(myLink);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
    
    /*--> Other details*/
    
    
    public TourHostDetails findTourHostDetails (int id) {
        return detailsRepo.findById(Integer.valueOf(id));
    }
    
    public TourHostDetails findDetailsByHost (TourHost host) {
        return detailsRepo.findByTourHost(host);
    }
    
    public TourHostPaymentInfo findPaymentInfo (int id) {
        return paymentRepo.findById(Integer.valueOf(id));
    }
    
    public TourHostPaymentInfo findPaymentInfoByHost (TourHost host) {
        return paymentRepo.findByTourHost(host);
    }
    
    public TourHostLocation findTourHostLocation (int id) {
        return locationRepo.findById(Integer.valueOf(id));
    }
    
    public TourHostLocation findTourHostLocationByHost (TourHost host) {
        return locationRepo.findByTourHost(host);
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
