package com.springjpa.controller;
 
import org.springframework.beans.factory.annotation.Autowired;

import com.springjpa.model.TourHost;
import com.springjpa.repo.TourHostRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class WebController {
	@Autowired
	TourHostRepository repository;
	
	@RequestMapping("/save")
	public String process(){
		repository.save(new TourHost("insider_sa", "34819d7beeabb9260a5c854bc85b3e44", "insider@sarajevo.ba", "Insider Sarajevo"));	
		repository.save(new TourHost("myBosnia", "81c93a6d22daaa5fdb4dbd4267e5e06e", "mybosnia@gmail.com", "My Bosnia"));
		return "Done";
	}	
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "";
		
		for(TourHost host : repository.findAll()){
			result += host.toString() + "<br>";
		}
		
		return result;
	}	
}