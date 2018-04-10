package com.example.tdboffers.repositories;

import com.example.tdboffers.models.TourHost;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITourHostRepository extends PagingAndSortingRepository<TourHost,Integer> {
    TourHost getTourHostByIdHost(Integer idHost);
}
