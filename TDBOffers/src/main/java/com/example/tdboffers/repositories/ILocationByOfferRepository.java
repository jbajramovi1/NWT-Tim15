package com.example.tdboffers.repositories;

import com.example.tdboffers.models.LocationByOffer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ILocationByOfferRepository extends PagingAndSortingRepository<LocationByOffer,Integer> {
}
