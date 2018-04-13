package com.example.tdboffers.repositories;

import com.example.tdboffers.models.Offer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IOfferRepository extends PagingAndSortingRepository<Offer,Integer> {
        Offer getOfferById(Integer id);
        List<Offer> getOfferByTourHost(Integer tourHost);
        List<Offer> findAll();
}