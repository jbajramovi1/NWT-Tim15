package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.model.TourHost;
import com.springjpa.model.Recommendation;


public interface TourHostRecommendationRepository extends JpaRepository<Recommendation, Integer> {
	public Recommendation findById(Integer id);
	public List<Recommendation> findByTourHost(TourHost tourHost);
}
