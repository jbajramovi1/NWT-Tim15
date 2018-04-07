package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Recommendation;
import com.example.demo.model.TourHost;

public interface TourHostRecommendationRepository extends JpaRepository<Recommendation, Integer> {
	public Optional<Recommendation> findById(Integer id);
	public List<Recommendation> findByTourHost(TourHost tourHost);
}
