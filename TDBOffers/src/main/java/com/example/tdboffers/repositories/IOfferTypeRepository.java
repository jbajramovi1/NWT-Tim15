package com.example.tdboffers.repositories;

import com.example.tdboffers.models.OfferType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IOfferTypeRepository extends PagingAndSortingRepository<OfferType,Integer> {
}
