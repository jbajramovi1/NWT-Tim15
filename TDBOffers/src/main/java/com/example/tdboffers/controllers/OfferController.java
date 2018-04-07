package com.example.tdboffers.controllers;

import com.example.tdboffers.models.Offer;
import com.example.tdboffers.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/offer")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @RequestMapping(value = "/create" ,consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Offer createOffer(@RequestBody Offer data){
        return offerService.createOffer(data);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getById(id));
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
