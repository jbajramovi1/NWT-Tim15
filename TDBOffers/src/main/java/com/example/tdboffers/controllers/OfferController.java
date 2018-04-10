package com.example.tdboffers.controllers;

import com.example.tdboffers.models.Offer;
import com.example.tdboffers.models.TourHost;
import com.example.tdboffers.services.OfferService;
import com.example.tdboffers.services.TourHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/offer")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @Autowired
    private TourHostService tourHostService;

    @RequestMapping(value = "/create" ,consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Object> createOffer(@RequestBody Offer data){
        TourHost tourHost=tourHostService.getById(data.getTourHost().getIdHost());
        if (tourHost==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No tour host with given id");
        }
        return ResponseEntity.status(HttpStatus.OK).body(offerService.createOffer(data));
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getById(id));
    }

    @RequestMapping(value = "/getbyhost/{host}", method = RequestMethod.GET)
    public ResponseEntity<Object> getOfferByHost(@PathVariable("host") Integer host){
        TourHost response = new RestTemplate().getForObject(
                "http://localhost:8080/tourhost?id={tourhost}", TourHost.class, host);
        if (response==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No tour host with given id");
        }

        return ResponseEntity.status(HttpStatus.OK).body(offerService.getByTourHost(host));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<Object> getOffers(){
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getAll());
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        offerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @RequestMapping(value = "update/{id}", consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Offer updateOffer(@RequestBody Offer data, @PathVariable("id") Integer id){
        return offerService.updateOffer(data,id);
    }


}
