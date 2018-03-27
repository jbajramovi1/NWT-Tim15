package com.example.tdboffers.repositories;

import com.example.tdboffers.models.Offer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IOfferRepository extends PagingAndSortingRepository<Offer,Integer> {

}
