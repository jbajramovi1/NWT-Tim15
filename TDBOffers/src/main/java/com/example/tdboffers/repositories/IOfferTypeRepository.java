package com.example.tdboffers.repositories;

import com.example.tdboffers.models.OfferType;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IOfferTypeRepository extends PagingAndSortingRepository<OfferType,Integer> {
    OfferType getOfferTypeById(Integer id);
    List<OfferType> findAll();
}
