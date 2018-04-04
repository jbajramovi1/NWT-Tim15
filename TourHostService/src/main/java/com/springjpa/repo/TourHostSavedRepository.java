package com.springjpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.model.TourHost;
import com.springjpa.model.SavedTourHost;;

public interface TourHostSavedRepository extends JpaRepository<SavedTourHost, Integer> {
	public Optional<SavedTourHost> findById(Integer id);
	public List<SavedTourHost> findByTourHost(TourHost tourHost);
}


