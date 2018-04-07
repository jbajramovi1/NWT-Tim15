package com.example.tdboffers.controllers;

import com.example.tdboffers.models.OfferSeason;
import com.example.tdboffers.services.OfferSeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/offerseason")
public class OfferSeasonController {

    @Autowired
    private OfferSeasonService offerSeasonService;

    @RequestMapping(value = "/create" ,consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OfferSeason createOffer(@RequestBody OfferSeason data){
        return offerSeasonService.createOfferSeason(data);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<OfferSeason> getOfferSeasonById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(offerSeasonService.getById(id));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<Object> getOfferSeasons(){
        return ResponseEntity.status(HttpStatus.OK).body(offerSeasonService.getAll());
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        offerSeasonService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @RequestMapping(value = "update/{id}", consumes = "application/json",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OfferSeason updateOfferSeason(@RequestBody OfferSeason data, @PathVariable("id") Integer id){
        return offerSeasonService.updateOfferSeason(data,id);
    }

}
