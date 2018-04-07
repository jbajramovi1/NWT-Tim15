package com.example.tdboffers.repositories;

import com.example.tdboffers.models.OfferSeason;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IOfferSeasonRepository extends PagingAndSortingRepository<OfferSeason,Integer> {
}
