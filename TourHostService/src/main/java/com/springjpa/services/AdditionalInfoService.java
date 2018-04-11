package com.springjpa.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springjpa.model.TourHost;
import com.springjpa.model.TourHostDetails;
import com.springjpa.model.TourHostPaymentInfo;
import com.springjpa.repo.TourHostDetailsRepository;
import com.springjpa.repo.TourHostPaymentInfoRepository;
import com.springjpa.repo.TourHostRepository;

@Service
public class AdditionalInfoService {

	@Autowired
	TourHostRepository hostRepo;	
	@Autowired
	TourHostDetailsRepository detailsRepo;
	@Autowired
	TourHostPaymentInfoRepository paymentRepo;
	
    
    public Optional<TourHostDetails> findTourHostDetails (int id) {
        return detailsRepo.findById(Integer.valueOf(id));
    }
    
    public TourHostDetails findDetailsByHost (TourHost host) {
        return detailsRepo.findByTourHost(host);
    }
    
    public Optional<TourHostPaymentInfo> findPaymentInfo (int id) {
        return paymentRepo.findById(Integer.valueOf(id));
    }
    
    public TourHostPaymentInfo findPaymentInfoByHost (TourHost host) {
        return paymentRepo.findByTourHost(host);
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
