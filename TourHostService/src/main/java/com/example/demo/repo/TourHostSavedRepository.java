package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SavedTourHost;
import com.example.demo.model.TourHost;

public interface TourHostSavedRepository extends JpaRepository<SavedTourHost, Integer> {
	public Optional<SavedTourHost> findById(Integer id);
	public List<SavedTourHost> findByTourHost(TourHost tourHost);
}
