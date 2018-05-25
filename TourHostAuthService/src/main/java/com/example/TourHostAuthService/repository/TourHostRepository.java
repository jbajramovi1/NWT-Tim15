package com.example.TourHostAuthService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TourHostAuthService.model.TourHost;

public interface TourHostRepository extends JpaRepository<TourHost, Integer> {
	TourHost findByUsername(String usernameTourHost);
}