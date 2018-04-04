package com.example.demo.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TourHost;
import com.example.demo.model.TourHostReview;

public interface TourHostReviewRepository extends JpaRepository<TourHostReview, Integer> {
	public Optional<TourHostReview> findById(Integer id);
	public List<TourHostReview> findByTourHost(TourHost tourHost);
}