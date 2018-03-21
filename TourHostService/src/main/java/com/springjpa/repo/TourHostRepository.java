package com.springjpa.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.springjpa.model.TourHost;



public interface TourHostRepository extends CrudRepository<TourHost, Long>{
	List<TourHost> findByNameTourHost(String nameTourHost);
}