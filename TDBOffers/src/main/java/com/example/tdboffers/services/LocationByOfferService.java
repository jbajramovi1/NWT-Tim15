package com.example.tdboffers.services;

import com.example.tdboffers.models.LocationByOffer;
import com.example.tdboffers.repositories.ILocationByOfferRepository;
import com.example.tdboffers.repositories.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public LocationByOffer getById(Integer id) {return locationByOfferRepository.getLocationByOffer(id);}

    public List<LocationByOffer> getAll() {return locationByOfferRepository.findAll();}

    public void deleteById(Integer id){
        locationByOfferRepository.deleteById(id);
    }

    public LocationByOffer updateLocationByOffer(LocationByOffer data, Integer id){
        LocationByOffer locationByOffer=locationByOfferRepository.getLocationByOffer(id);
        if (data.getOffer()!=null) locationByOffer.setOffer(data.getOffer());
        if (data.getLocation()!=null) locationByOffer.setLocation(data.getLocation());

        return locationByOfferRepository.save(locationByOffer);
    }
}
