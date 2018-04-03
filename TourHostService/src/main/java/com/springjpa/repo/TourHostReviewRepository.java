package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.model.TourHostReview;
import com.springjpa.model.TourHost;

public interface TourHostReviewRepository extends JpaRepository<TourHostReview, Integer> {
	public TourHostReview findById(Integer id);
	public List<TourHostReview> findByTourHost(TourHost tourHost);
}

