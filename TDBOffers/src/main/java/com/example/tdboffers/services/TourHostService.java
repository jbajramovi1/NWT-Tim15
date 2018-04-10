package com.example.tdboffers.services;

import com.example.tdboffers.models.TourHost;
import com.example.tdboffers.repositories.ITourHostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourHostService {
    @Autowired
    private ITourHostRepository tourHostRepository;

    public TourHost getById(Integer id){
        return tourHostRepository.getTourHostByIdHost(id);
    }

    public TourHost createTourHost(TourHost data){
        TourHost tourHost=new TourHost();
        tourHost.setId(data.getId());

        return tourHostRepository.save(tourHost);
    }
}
