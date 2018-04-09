package com.springjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springjpa.model.Recommendation;
import com.springjpa.model.TourHost;
import com.springjpa.repo.TourHostRecommendationRepository;
import com.springjpa.repo.TourHostRepository;

@Service
public class RecommendationService {
	@Autowired
	TourHostRepository hostRepo;
	
	@Autowired
	TourHostRecommendationRepository recomRepo;
	
	/*public ResponseEntity<Object> removeReview(int id) {
    	if (recomRepo.findById(id)==null)
    		ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This recommendation doesn't exist!");    	
    	recomRepo.delete(recomRepo.findById(id));   	
    	return ResponseEntity.status(HttpStatus.OK).body(true);
	}*/
	
	public List<Recommendation> findRecommendationsByTourHost (TourHost tourHost) {
        return recomRepo.findByTourHost(tourHost);
    }
	
    public ResponseEntity<Object> registerRecommendation(Recommendation recommendation) {
    	Recommendation r = recomRepo.findByTourHostAndUser(recommendation.getTourHost(), recommendation.getUser());
    	if (r == null)
	        recomRepo.save(recommendation);
	    
    	return ResponseEntity.status(HttpStatus.OK).body("");
    }
}