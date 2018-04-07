package com.example.tdboffers.services;

import com.example.tdboffers.models.Location;
import com.example.tdboffers.repositories.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

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

    public Location getById(Integer id) {return locationRepository.getLocationById(id);}

    public List<Location> getAll() {return locationRepository.findAll();}

    public void deleteById(Integer id){
        locationRepository.deleteById(id);
    }

    public Location updateLocation(Location data, Integer id){
        Location location=getById(id);
        if (data.getName()!=null) location.setName(data.getName());
        if (data.getLatitude()!=null) location.setLatitude(data.getLatitude());
        if (data.getLongitude()!=null) location.setLongitude(data.getLongitude());

        return locationRepository.save(location);
    }

}
