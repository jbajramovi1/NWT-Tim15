package com.example.tdboffers.repositories;

import com.example.tdboffers.models.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ILocationRepository extends PagingAndSortingRepository<Location,Integer> {
}
