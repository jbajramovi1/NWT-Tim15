package com.example.tdboffers.repositories;

import com.example.tdboffers.models.LocationByOffer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ILocationByOfferRepository extends PagingAndSortingRepository<LocationByOffer,Integer> {
    LocationByOffer getLocationByOffer(Integer id);
    List<LocationByOffer> findAll();
}
