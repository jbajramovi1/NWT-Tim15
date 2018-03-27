package com.example.tdboffers.services;

import com.example.tdboffers.models.Location;
import com.example.tdboffers.repositories.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private ILocationRepository locationRepository;

    public Location createLocation(Location data){
        Location location=new Location();
        location.setName(data.getName());
        location.setLatitude(data.getLatitude());
        location.setLatitude(data.getLongitude());

        return locationRepository.save(location);
    }

}
