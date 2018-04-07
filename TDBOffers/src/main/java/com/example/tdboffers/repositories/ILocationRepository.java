package com.example.tdboffers.repositories;

import com.example.tdboffers.models.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ILocationRepository extends PagingAndSortingRepository<Location,Integer> {
    Location getLocationById(Integer id);
    List<Location> findAll();
}
