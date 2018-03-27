package com.example.tdboffers.services;

import com.example.tdboffers.models.LocationByOffer;
import com.example.tdboffers.repositories.ILocationByOfferRepository;
import com.example.tdboffers.repositories.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationByOfferService {
    @Autowired
    private ILocationByOfferRepository locationByOfferRepository;

    public LocationByOffer createLocationByOffer(LocationByOffer data){
        LocationByOffer locationByOffer=new LocationByOffer();

        locationByOffer.setLocation(data.getLocation());
        locationByOffer.setOffer(data.getOffer());
        return locationByOfferRepository.save(locationByOffer);
    }
}
