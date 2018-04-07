package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TourHostDetails;
import com.example.demo.model.TourHost;

@Repository
public interface TourHostDetailsRepository extends JpaRepository<TourHostDetails, Integer> {
	public Optional<TourHostDetails> findById(Integer id);
	public TourHostDetails findByTourHost(TourHost tourHost);
}