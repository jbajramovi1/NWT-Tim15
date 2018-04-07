package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TourHost;
import com.example.demo.model.TourHostLocation;

@Repository
public interface TourHostLocationRepository extends JpaRepository<TourHostLocation, Integer> {
	public Optional<TourHostLocation> findById(Integer id);
	public TourHostLocation findByTourHost(TourHost tourHost);
}
