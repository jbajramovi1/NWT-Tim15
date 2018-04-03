package com.springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.model.TourHostDetails;
import com.springjpa.model.TourHost;

@Repository
public interface TourHostDetailsRepository extends JpaRepository<TourHostDetails, Integer> {
	public TourHostDetails findById(Integer id);
	public TourHostDetails findByTourHost(TourHost tourHost);
}
