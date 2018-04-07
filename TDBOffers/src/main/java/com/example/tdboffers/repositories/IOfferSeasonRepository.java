package com.example.tdboffers.repositories;

import com.example.tdboffers.models.OfferSeason;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IOfferSeasonRepository extends PagingAndSortingRepository<OfferSeason,Integer> {
    OfferSeason getOfferSeasonById(Integer id);
    List<OfferSeason> findAll();
}
