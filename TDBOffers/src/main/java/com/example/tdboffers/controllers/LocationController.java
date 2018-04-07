package com.example.tdboffers.controllers;

import com.example.tdboffers.models.Location;
import com.example.tdboffers.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id){
        locationService.deleteById(id);
    }
}
