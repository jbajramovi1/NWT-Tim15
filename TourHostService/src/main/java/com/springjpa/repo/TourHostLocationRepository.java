package com.springjpa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.model.TourHost;
import com.springjpa.model.TourHostLocation;

@Repository
public interface TourHostLocationRepository extends JpaRepository<TourHostLocation, Integer> {
	public Optional<TourHostLocation> findById(Integer id);
	public TourHostLocation findByTourHost(TourHost tourHost);
}

