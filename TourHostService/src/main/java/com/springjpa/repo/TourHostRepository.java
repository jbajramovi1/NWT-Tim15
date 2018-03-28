package com.springjpa.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.model.TourHost;

public interface TourHostRepository extends JpaRepository<TourHost, Integer> {
	List<TourHost> findByNameTourHost(String nameTourHost);
	TourHost findByUsernameTourHost(String usernameTourHost);
	List<TourHost> findAll();
	TourHost findByIdTourHost(Integer id);
}