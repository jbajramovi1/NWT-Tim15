package com.example.demo.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TourHost;

public interface TourHostRepository extends JpaRepository<TourHost, Integer> {
	List<TourHost> findByNameTourHost(String nameTourHost);
	TourHost findByUsernameTourHost(String usernameTourHost);
	List<TourHost> findAll();
	TourHost findByIdTourHost(Integer id);
}
