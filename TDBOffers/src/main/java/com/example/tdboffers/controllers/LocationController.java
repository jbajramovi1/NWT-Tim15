package com.example.tdboffers.controllers;

import com.example.tdboffers.models.Location;
import com.example.tdboffers.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/create",consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Location createLocation(@RequestBody Location data){
        return locationService.createLocation(data);
    }


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Location> getLocationById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.getById(id));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<Object> getLocations(){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.getAll());
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> deleteLocation(@PathVariable("id") Integer id){
        locationService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @RequestMapping(value = "update/{id}", consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Location updateOffer(@RequestBody Location data, @PathVariable("id") Integer id){
        return locationService.updateLocation(data,id);
    }
}
