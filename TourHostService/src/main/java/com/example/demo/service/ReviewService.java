package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.repo.TourHostReviewRepository;
import com.example.demo.model.TourHost;
import com.example.demo.model.TourHostReview;
import com.example.demo.repo.TourHostRepository;

@Service
public class ReviewService {
	@Autowired
	TourHostRepository hostRepo;
	
	@Autowired
	TourHostReviewRepository reviewRepo;
	
	/*public ResponseEntity<Object> removeReview(int id) {
    	if (reviewRepo.findById(id)==null)
    		ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This review doesn't exist!");    	
    	reviewRepo.delete(reviewRepo.findById(id));   	
    	return ResponseEntity.status(HttpStatus.OK).body(true);
	}*/
	
	public List<TourHostReview> findReviewsByTourHost (TourHost tourHost) {
        return reviewRepo.findByTourHost(tourHost);
    }
}
